package presentacio;


import domini.patroComposite.SensorIndividual;
import domini.patroFacade.FacadeSistema;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SistemaFrame extends JFrame {

    private JTextArea textArea;
    private int id;

    public SistemaFrame(int id) throws IOException {
        this.id = id;

        setTitle("Monitoratge ambiental");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Botons inferiors
        JPanel panellBotons = new JPanel();

        JButton botoLectures = new JButton("Lectures actuals");
        JButton botoHistoric = new JButton("Històric");
        JButton botoAfegirDispositiu = new JButton("Afegir dispositiu");
        JButton botoConsells = new JButton("Consells Medio Ambientals");

        botoLectures.addActionListener(e -> obtenirLecturesActuals());
        botoHistoric.addActionListener(e -> obtenirHistoric());
        botoAfegirDispositiu.addActionListener(e -> afegirDispositiu());
        botoConsells.addActionListener(e -> consellMedioAmbientals());

        panellBotons.add(botoLectures);
        if( FacadeSistema.getTipusUsuari(id) == 1)
            panellBotons.add(botoHistoric);
        panellBotons.add(botoAfegirDispositiu);
        panellBotons.add(botoConsells);

        add(panellBotons, BorderLayout.SOUTH);
    }

    private void obtenirLecturesActuals(){
        try {
            textArea.setText(FacadeSistema.obtenirLecturesActuals(id));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void obtenirHistoric(){
        try {
            textArea.setText(FacadeSistema.obtenirHistoric(id));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void afegirDispositiu() {
        try {
            String nom = JOptionPane.showInputDialog(this, "Nom del dispositiu compost:");
            if (nom == null || nom.isBlank()) return;

            SensorIndividual.Tipus[] opcions = SensorIndividual.Tipus.values();

            JList<SensorIndividual.Tipus> llista = new JList<>(opcions);
            llista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JScrollPane scrollPane = new JScrollPane(llista);
            scrollPane.setPreferredSize(new Dimension(200, 120));

            int resultat = JOptionPane.showConfirmDialog(
                    this,
                    scrollPane,
                    "Selecciona els tipus de sensors (CTRL):",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (resultat == JOptionPane.OK_OPTION) {
                SensorIndividual.Tipus[] seleccio = new SensorIndividual.Tipus[0];
                FacadeSistema.afegirDispositiu(id,nom, llista.getSelectedValuesList().toArray(seleccio));
            } else {
                JOptionPane.showMessageDialog(this, "Entrada no vàlida.");

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consellMedioAmbientals(){
        try {
            textArea.setText(FacadeSistema.consellMedioAmbientals(id));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

