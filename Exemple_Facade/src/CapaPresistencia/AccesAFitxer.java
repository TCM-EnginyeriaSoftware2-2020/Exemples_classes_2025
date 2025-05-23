package CapaPresistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class AccesAFitxer {

    private Properties fitxer ;
    private static AccesAFitxer instance = new AccesAFitxer();
    private AccesAFitxer() {
        fitxer= new Properties();
        try {
            fitxer.load(new FileInputStream(new File("Files/permisos.propierty")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AccesAFitxer getInstance() {
        return instance;
    }

    public boolean tePermisos(int client, String subSystem){

        String retorn = (String) fitxer.get(String.valueOf(client));

        return retorn.contains(subSystem);
    }



}
