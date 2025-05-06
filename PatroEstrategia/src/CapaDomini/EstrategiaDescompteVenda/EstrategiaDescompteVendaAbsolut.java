package CapaDomini.EstrategiaDescompteVenda;

import CapaDomini.Venda;

public class EstrategiaDescompteVendaAbsolut implements
		IEstrategiaDescompteVenda {

	private float descompte;
	private float llinda;

	public EstrategiaDescompteVendaAbsolut(float descompte, float llinda) {
		if( descompte > llinda) throw new IllegalArgumentException("descompte incorrecte");
		this.descompte = descompte;
		this.llinda = llinda;
	}

	@Override
	public float getTotal(Venda venda) {
		float subtotal = venda.getTotalAbansDte();
		if( subtotal > llinda)
			return subtotal - descompte;
		return subtotal;
	}

	public String toString() {
		return "Estrategia Descompte Absolut: Llinda = " + llinda
				+ ", descompte = " + descompte;
	}
}
