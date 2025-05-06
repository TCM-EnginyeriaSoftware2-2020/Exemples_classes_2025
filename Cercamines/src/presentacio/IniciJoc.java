package presentacio;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domini.Casella;

public class IniciJoc extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private CasellaGrafica taulellGrafic;
	private Casella casellaAmbMina;

	public static void main(String[] args) {
			new IniciJoc();				
	}

	private IniciJoc() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 600);		
		this.setTitle("JOC DEL CERCA MINES.     Butó dret=marcar/desmarcar. Butó esquerra=destapar");
		this.inicialitzarJoc();
	}
	
	private void inicialitzarJoc() {
		//1- inicialitzar l'atribut joc. Si dóna error informar i finalitzar
		casellaAmbMina = new Casella(false);
		/* 2- Crear un nou objecte de la interfície MouseListener redefinint el mètode 
		*    mouseClicked(MouseEvent mouseEvent) de la classe abstracta MouseAdapter.*/

		//3- Crear l'atribut taulellGrafic
		int files = 1;
		int columnes = 1;
		//4- Definir i crear una variable panell del tipus ContentPane
		JPanel contentPane = new JPanel();
		//5- Definir i crear una variable GridLayout de les mides del taulell del joc
		GridLayout tg = new GridLayout(files, columnes, 1, 1);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
		//6- setejar el layout del panell amb el gridLayout
		contentPane.setLayout(tg);
		//7- inicialitzar l'atribut taulellGrafic amb objectes CasellaGrafica.
		for(int fila = 0 ; fila < files; fila++)
			for (int columna = 0 ; columna < columnes; columna++){
				/*7.1 afegir-hi l'escoltador (addMouseListener()) creat en el pas 2
				 *7.2 afegir el nou objecte al panell
				 *7.3 afegir el nou objete al taulellGrafic*/
				taulellGrafic = new CasellaGrafica (fila, columna);				
				taulellGrafic.addMouseListener(this);				
				contentPane.add(taulellGrafic);
			}
		//8- setegjr el ContentPane del JFrame amb el nostre panell
		setContentPane(contentPane);
		//9- Fer visible el JFrame
		this.setVisible(true);
	}

	private void marcarDesmarcarCasella() {
		try {
			casellaAmbMina.setPosibleMina();
			mostrarTaulellGrafic();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"ERROR al destsapar", JOptionPane.ERROR_MESSAGE);
		}	
	}

	private void destaparCasella() {
		try {
			casellaAmbMina.destapar();
			mostrarTaulellGrafic();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"ERROR al destsapar", JOptionPane.ERROR_MESSAGE);
		}		
	}

	private void mostrarTaulellGrafic (){
		String  text = casellaAmbMina.getContingut();
		taulellGrafic.setText(text);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//2.1 obtenir la casellaGrafica que ha provocat l'event (getComponent).
		CasellaGrafica casella = (CasellaGrafica)e.getComponent();
		//2.2 Esbrinar quin botó del mouse s'ha premut
		if (e.getButton() == MouseEvent.BUTTON1) {
		//2.2.1 Si és el botó esquerre, cridar el mètode destaparCasella()
			this.destaparCasella ();
		} else if (e.getButton() == MouseEvent.BUTTON3) {
		//2.2.2 Si és el botó dret, cridar el mètode marcarDesmarcarCasella()
			this.marcarDesmarcarCasella ();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}