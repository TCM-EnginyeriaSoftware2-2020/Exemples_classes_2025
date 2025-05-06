package CapaDomini.AbstractFactory;

import CapaDomini.Bloc.BlocGameBoy;
import CapaDomini.Bloc.IBloc;
import CapaDomini.Moneda.IMoneda;
import CapaDomini.Moneda.MonedaGameBoy;

public class FactoriaGameBoy implements FactoriaAbstracte{

    private static  FactoriaGameBoy instanciaUnica;
    private FactoriaGameBoy(){}

    public static synchronized FactoriaGameBoy getInstanciaUnica() {
        if( instanciaUnica == null) instanciaUnica = new FactoriaGameBoy();
        return instanciaUnica;
    }

    @Override
    public IMoneda creaMoneda() {
        return new MonedaGameBoy();
    }

    @Override
    public IBloc creaBloc() {
        return new BlocGameBoy();
    }
}
