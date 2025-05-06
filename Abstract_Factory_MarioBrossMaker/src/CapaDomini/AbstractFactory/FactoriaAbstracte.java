package CapaDomini.AbstractFactory;

import CapaDomini.Bloc.IBloc;
import CapaDomini.Moneda.IMoneda;

public interface FactoriaAbstracte {

    public abstract IMoneda creaMoneda();
    public abstract IBloc creaBloc();

}
