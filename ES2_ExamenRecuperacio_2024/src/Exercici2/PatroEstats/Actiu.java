package Exercici2.PatroEstats;

public abstract class Actiu implements IEstats {
    public static long DURATION = 72; // cal posar 2 hores = 7200000 mil·lisegons
    protected long initTime;

    protected boolean extraFort;
    public Actiu( long initTime, boolean extraFort)
    {
        this.initTime = initTime;
        this.extraFort = extraFort;
    }
    public Actiu(){
        this(System.currentTimeMillis(), false);
    }

    @Override
    public IEstats botoVentilador() {
        if( this.extraFort ) // passa a OFF
            return Inactiu.getEstatUnic();
        this.extraFort = true; // passa a extra fort
        return this;
    }


}
