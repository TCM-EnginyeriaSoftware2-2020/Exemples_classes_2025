package domini;

import domini.PatroEstats.IEstatCasella;

public class Casella {

	private boolean mina;
	/*
	 * contindrà un dels tres possibles estats d'una casella: Inicialment tapada i
	 * desmarcada o bé Tapada i marcada com a possible mina o bé Destapada
	 */
	protected IEstatCasella estat;

	public Casella(boolean mina) {
		this.mina = mina;
		this.estat = IEstatCasella.getEstatInicial();
	}

	// Retrona cert si la casella està destapada, fals altrament
	public boolean estaDestapada() {
		return this.estat.isVisible();
	}

	// Destapa la casella
	public void destapar() {
		this.estat = this.estat.destapar();
		if (this.mina)
			throw new RuntimeException("Has perdut! aquesta casella té una mina.");
	}

	public void setPosibleMina() {
		if (!this.estaMarcadaPosibleMina()) {
			this.estat = this.estat.marcar();
		} else {
			this.estat = this.estat.desmarcar();
		}
	}

	// Retorna si la casella està o no marcada
	public boolean estaMarcadaPosibleMina() {
		return this.estat.isMarcada();
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