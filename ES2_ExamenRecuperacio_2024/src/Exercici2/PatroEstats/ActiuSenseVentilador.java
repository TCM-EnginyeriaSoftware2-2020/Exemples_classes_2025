package Exercici2.PatroEstats;

public class ActiuSenseVentilador extends Actiu{
    @Override
    public IEstats botoON() {
        return new ActiuSenseVentilador();
    }
    @Override
    public IEstats sensor(boolean activar) {
        if( System.currentTimeMillis() - this.initTime > DURATION )
            return Inactiu.getEstatUnic();
        if(activar)
            return new ActiuAmbVentilador(this.initTime, this.extraFort);
        return this;
    }

}
