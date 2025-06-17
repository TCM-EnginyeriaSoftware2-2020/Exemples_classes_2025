package domini.patroFacade;

import domini.patroAbstractFactory.FactoriaDomestica;
import domini.patroAbstractFactory.FactoriaIndustrial;
import domini.patroAbstractFactory.IAbstractFactory;
import domini.patroComposite.ISensor;
import domini.patroComposite.SensorIndividual;

import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoratge {
    public enum Usuari {Domèstic, Industrial};
    private Usuari tipusUsuari;
    private IAbstractFactory factoria;
    private List<ISensor> dispositius = new ArrayList<>();

    public SistemaMonitoratge(Usuari tipusUsuari) {
        this.tipusUsuari = tipusUsuari;
        switch (tipusUsuari){
            case Domèstic: this.factoria = FactoriaDomestica.getInstance(); break;
            case Industrial: this.factoria = FactoriaIndustrial.getInstance(); break;
            default: throw new IllegalArgumentException("tipud d'usuari incorrecte");
        }
    }

    public Usuari getTipusUsuari() {
        return tipusUsuari;
    }

    public List<ISensor> getDispositius() {
        return dispositius;
    }
    private void afegirDispositiu(ISensor dispositiu) {
        dispositius.add(dispositiu);
    }
    public void afegirDispositiu(String nom, SensorIndividual.Tipus[] seleccio) {
        afegirDispositiu(factoria.crearDispositiu(nom,seleccio));
    }
    public String obtenirLecturesActuals() {
        StringBuilder sb = new StringBuilder();
        for (ISensor d : dispositius) {
            sb.append("Dispositiu: ");
            sb.append( d.obtenirLectura() );
            sb.append("\n");
        }
        return sb.toString();
    }
    public String obtenirHistoric() {
        StringBuilder sb = new StringBuilder();
        for (ISensor d : dispositius) {
            sb.append("Dispositiu: ");
            sb.append( d.obtenirHistoric() );
            sb.append("\n");
        }
        return sb.toString();
    }

}

