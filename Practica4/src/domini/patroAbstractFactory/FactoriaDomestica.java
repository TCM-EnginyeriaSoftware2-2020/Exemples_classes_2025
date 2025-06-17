package domini.patroAbstractFactory;

import domini.patroComposite.DispositiuCompost;
import domini.patroComposite.ISensor;
import domini.patroComposite.SensorIndividual;

public class FactoriaDomestica implements IAbstractFactory {
    //patró singleton
    private static FactoriaDomestica instance = new FactoriaDomestica();
    private FactoriaDomestica(){}
    public static FactoriaDomestica getInstance() { return instance;}
    //factoria concreta de l'àmbit industrial
    @Override
    public SensorIndividual crearSensorIndividual(String nom, SensorIndividual.Tipus seleccio) {
        return new SensorIndividual(nom, seleccio);
    }

    @Override
    public DispositiuCompost crearDispositiu(String nom, SensorIndividual.Tipus[] selArray) {
        DispositiuCompost dispositiu = new DispositiuCompost(nom);
        for (SensorIndividual.Tipus seleccio: selArray) {
            dispositiu.afegir(this.crearSensorIndividual(nom+seleccio, seleccio));
        }
        return dispositiu;
    }
}

