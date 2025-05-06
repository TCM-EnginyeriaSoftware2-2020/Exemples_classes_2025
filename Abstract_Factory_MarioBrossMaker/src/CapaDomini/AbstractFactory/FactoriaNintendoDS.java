package CapaDomini.AbstractFactory;

import CapaDomini.Bloc.BlocGameBoy;
import CapaDomini.Bloc.BlocNintendoDS;
import CapaDomini.Bloc.IBloc;
import CapaDomini.Moneda.IMoneda;
import CapaDomini.Moneda.MonedaGameBoy;
import CapaDomini.Moneda.MonedaNintendoDS;

public final class FactoriaNintendoDS implements FactoriaAbstracte{

    private static FactoriaNintendoDS instanciaUnica = new FactoriaNintendoDS();
    private FactoriaNintendoDS(){}
    public static FactoriaNintendoDS getInstanciaUnica(){ return  instanciaUnica;}

    @Override
    public IMoneda creaMoneda() {
        return new MonedaNintendoDS();
    }

    @Override
    public IBloc creaBloc() {
        return new BlocNintendoDS();
    }
}
