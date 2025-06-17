package domini.patroAbstractFactory;

import domini.patroComposite.DispositiuCompost;
import domini.patroComposite.ISensor;
import domini.patroComposite.SensorIndivAvan;
import domini.patroComposite.SensorIndividual;

public final class FactoriaIndustrial implements IAbstractFactory {
    //patró singleton
    private static FactoriaIndustrial instance = new FactoriaIndustrial();
    private FactoriaIndustrial(){}
    public static FactoriaIndustrial getInstance() { return instance;}
    //factoria concreta de l'àmbit industrial
    @Override
    public SensorIndividual crearSensorIndividual(String nom, SensorIndividual.Tipus seleccio) {
        return new SensorIndivAvan(nom, seleccio);
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

