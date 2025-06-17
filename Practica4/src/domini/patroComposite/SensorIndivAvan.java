package domini.patroComposite;

import java.util.ArrayList;
import java.util.List;

public class SensorIndivAvan extends SensorIndividual {

    List<Double> historic;

    public SensorIndivAvan(String nom, Tipus tipus) {
        super(nom, tipus);
        historic = new ArrayList<>();
        historic.add(lectura);
    }

    @Override
    public String obtenirLectura() {
        getLectura();
        historic.add(0, lectura);
        return tipus.name() +": " + lectura;
    }
    @Override
    public String obtenirHistoric() {
        getLectura();
        historic.add(0,lectura);
        String aux = tipus.name();
        for (Double valor: historic) {
            aux += ": "+ valor;
        }
        return aux;
    }

}
