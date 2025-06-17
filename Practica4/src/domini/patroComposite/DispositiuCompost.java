package domini.patroComposite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispositiuCompost implements ISensor {
    private String nom;
    private List<ISensor> components = new ArrayList<>();

    public DispositiuCompost(String nom) {
        this.nom = nom;
    }

    public boolean afegir(ISensor dispositiu) {
        if(dispositiu != null && dispositiu instanceof SensorIndividual)
            return components.add(dispositiu);
        return false;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String obtenirLectura() {
        String aux = nom ;
        for (ISensor d : components) {
            aux += "\n - " + d.obtenirLectura();
        }
        return aux;
    }

    @Override
    public String obtenirHistoric() {
        String aux = nom ;
        for (ISensor d : components) {
            aux += "\n - " + d.obtenirHistoric();
        }
        return aux;
    }
}
