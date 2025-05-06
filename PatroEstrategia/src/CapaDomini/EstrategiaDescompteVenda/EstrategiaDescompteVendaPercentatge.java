package CapaDomini.EstrategiaDescompteVenda;

import CapaDomini.Venda;

public class EstrategiaDescompteVendaPercentatge implements
		IEstrategiaDescompteVenda {

	private float percentatge;

	public EstrategiaDescompteVendaPercentatge(float percentatge) {
		if(percentatge > 1 || percentatge < 0)
			throw new IllegalArgumentException("valor percentatge incorrecte");
		this.percentatge = percentatge;
	}

	@Override
	public float getTotal(Venda venda) {
		//Pendent implementar
		return venda.getTotalAbansDte() * (1-percentatge);
	}

	public String toString() {
		return "Estrategia Descompte Percentatge = " + percentatge;
	}
}