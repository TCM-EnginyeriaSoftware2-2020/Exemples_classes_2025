package Exercici2.PatroEstats;

public interface IEstats {
    public abstract IEstats botoON();
    public abstract IEstats botoVentilador();
    public abstract IEstats sensor(boolean activar);

    public static IEstats getEstatInicial(){ return Inactiu.getEstatUnic(); }
}
