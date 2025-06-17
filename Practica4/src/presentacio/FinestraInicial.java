package presentacio;

import domini.patroFacade.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FinestraInicial extends JFrame {

    private JTextField campUsuari;

    private FinestraInicial() {
        super("Carregador de Dispositius");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        JLabel etiqueta = new JLabel("Introdueix ID d'usuari:");
        etiqueta.setBounds(20, 20, 150, 25);
        this.add(etiqueta);

        campUsuari = new JTextField();
        campUsuari.setBounds(180, 20, 150, 25);
        this.add(campUsuari);

        JButton botoCarregar = new JButton("Carregar");
        botoCarregar.setBounds(140, 60, 100, 30);
        this.add(botoCarregar);

        botoCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarUsuari();
            }
        });
    }

    private void carregarUsuari() {
        try {
            int id = Integer.parseInt(campUsuari.getText());
            new SistemaFrame(id).setVisible(true);
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Introdueix un número vàlid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FinestraInicial().setVisible(true);
        });
    }
}

