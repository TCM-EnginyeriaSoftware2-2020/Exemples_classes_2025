package domini;

import domini.PatroEstats.IEstatCasella;

public class Casella {

	private boolean mina;
	/*
	 * contindr� un dels tres possibles estats d'una casella: Inicialment tapada i
	 * desmarcada o b� Tapada i marcada com a possible mina o b� Destapada
	 */
	protected IEstatCasella estat;

	public Casella(boolean mina) {
		this.mina = mina;
		this.estat = IEstatCasella.getEstatInicial();
	}

	// Retrona cert si la casella est� destapada, fals altrament
	public boolean estaDestapada() {
		return this.estat.isVisible();
	}

	// Destapa la casella
	public void destapar() {
		this.estat = this.estat.destapar();
		if (this.mina)
			throw new RuntimeException("Has perdut! aquesta casella t� una mina.");
	}

	public void setPosibleMina() {
		if (!this.estaMarcadaPosibleMina()) {
			this.estat = this.estat.marcar();
		} else {
			this.estat = this.estat.desmarcar();
		}
	}

	// Retorna si la casella est� o no marcada
	public boolean estaMarcadaPosibleMina() {
		return this.estat.isMarcada();
	}


	public char getContingut() {
		if (this.estaDestapada() && this.mina) {
			return 'M';
		}
		if (this.estaMarcadaPosibleMina()) {
			return 'X';
		}
		return ' ';
	}
}