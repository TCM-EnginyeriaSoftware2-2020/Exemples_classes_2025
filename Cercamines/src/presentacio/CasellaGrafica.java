package presentacio;

import javax.swing.JButton;

public class CasellaGrafica extends JButton{
	
	private int fila;
	private int columna;
	
	public CasellaGrafica (int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

}
