package CapaAplicacio;

import CapaDomini.EstrategiaDescompteVenda.EstrategiaDescompteVendaAbsolut;
import CapaDomini.EstrategiaDescompteVenda.IEstrategiaDescompteVenda;
import CapaPersistencia.SimulacioBBDD.SimulacioBBDDDescomptesPreusVenda;

public  class FactoriaEstrategiaDescompteVendaAbsolut extends
		FactoriaAbstracteEstrategiaDescompteVenda {

	private static FactoriaEstrategiaDescompteVendaAbsolut instanciaUnica;

	private FactoriaEstrategiaDescompteVendaAbsolut(){}

	public synchronized static FactoriaEstrategiaDescompteVendaAbsolut getInstanciaUnica() {
		if( instanciaUnica == null)
			instanciaUnica = new FactoriaEstrategiaDescompteVendaAbsolut();
		return instanciaUnica;
	}

	@Override
	protected IEstrategiaDescompteVenda obtenirEstrategiaDecompte() {
		float[] valors = SimulacioBBDDDescomptesPreusVenda.getInstanciaUnica().getDescompteAbsolut();
		return new EstrategiaDescompteVendaAbsolut(valors[0], valors[1]);
	}
}