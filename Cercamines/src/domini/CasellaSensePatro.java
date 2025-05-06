package domini;

import domini.PatroEstats.IEstatCasella;

public class CasellaSensePatro {

	private boolean mina;
	/*
	 * contindr? un dels tres possibles estats d'una casella: Inicialment tapada i
	 * desmarcada o b? Tapada i marcada com a possible mina o b? Destapada
	 */
	private int estat; // 0 - inicial, 1-marcada, 2-visiable

	public CasellaSensePatro(boolean mina) {
		this.mina = mina;
		this.estat = 0;
	}

	// Retrona cert si la casella est? destapada, fals altrament
	public boolean estaDestapada() {
		return this.estat == 2;
	}

	// Destapa la casella
	public void destapar() {
		this.estat = 2;
		if (this.mina)
			throw new RuntimeException("Has perdut! aquesta casella t? una mina.");
	}

	public void setPosibleMina() {
		if (this.estat == 1) {
			this.estat = 0;
		} else if( this.estat == 0) {
			this.estat = 1;
		}
	}

	// Retorna si la casella est? o no marcada
	public boolean estaMarcadaPosibleMina() {
		return this.estat == 1;
	}

	/* Actualitzar l'estat de la casella */
	/*private void setEstat(IEstatCasella nouEstat) {
		if (nouEstat == null) {
			throw new IllegalArgumentException("Error definir estat casella: l'estat no pot ser nul.");
		}
		this.estat = nouEstat;
	}*/

	public boolean hiHaMina() {
		return true;
	}

	public boolean esBuida() {
		return false;
	}

	public String getContingut() {
		if (this.estaDestapada()) {
			return "Mina";
		}
		if (this.estaMarcadaPosibleMina()) {
			return "X";
		}
		return " ";
	}
}