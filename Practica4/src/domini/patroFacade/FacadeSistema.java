package domini.patroFacade;

import domini.patroComposite.SensorIndividual;
import persistencia.GestorUsuaris;

import java.io.IOException;

public class FacadeSistema {

    private static int userId;
    private static SistemaMonitoratge sistema;

    private FacadeSistema(){}
    private static void setUsuari(int newUser) throws IOException {
        if(sistema == null || userId != newUser ) {
            userId = newUser;
            sistema = GestorUsuaris.getInstance().carregarSistemaPerUsuari(userId);
        }
    }

    public static String obtenirLecturesActuals (int newUser) throws IOException {
        setUsuari(newUser);
        return sistema.obtenirLecturesActuals();
    }

    public static String obtenirHistoric (int newUser) throws IOException {
        setUsuari(newUser);
        return sistema.obtenirHistoric();
    }

    public static void afegirDispositiu(int newUser, String nom, SensorIndividual.Tipus[] seleccio) throws IOException {
        setUsuari(newUser);
        sistema.afegirDispositiu(nom, seleccio);
    }

    public static String consellMedioAmbientals(int newUser) throws IOException {
        setUsuari(newUser);
        return ConsellMedioAmbientals.get(sistema.getTipusUsuari());
    }
    public static int getTipusUsuari(int newUser) throws IOException {
        setUsuari(newUser);
        return sistema.getTipusUsuari().ordinal();
    }
}
