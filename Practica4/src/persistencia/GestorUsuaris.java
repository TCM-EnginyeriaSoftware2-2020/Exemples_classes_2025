package persistencia;


import domini.patroComposite.SensorIndividual;
import domini.patroFacade.SistemaMonitoratge;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuaris {

    private static GestorUsuaris instance;
    private String path = "files/usuari.json";
    private JSONArray usuaris;
    private GestorUsuaris() throws IOException {
        // Llegim tot el fitxer JSON com un String
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        String linia;
        while ((linia = reader.readLine()) != null) {
            sb.append(linia);
        }
        reader.close();

        // Parsejem com JSONArray
        usuaris = new JSONArray(sb.toString());
    }

    public synchronized static GestorUsuaris getInstance() throws IOException {
        if(instance == null)
            instance = new GestorUsuaris();
        return instance;
    }

    public SistemaMonitoratge carregarSistemaPerUsuari(int userId) {
            for (int i = 0; i < usuaris.length(); i++) {
                JSONObject usuari = usuaris.getJSONObject(i);

                if (usuari.getInt("user") == userId) {
                    String tipus = usuari.getString("tipus");
                    JSONObject dispositiuJson = usuari.getJSONObject("dispositiu");

                    String nomDispositiu = dispositiuJson.getString("nom");
                    JSONArray tipusArray = dispositiuJson.getJSONArray("tipus");

                    List<SensorIndividual.Tipus> tipusSensorsList = new ArrayList<>();
                    for (int j = 0; j < tipusArray.length(); j++) {
                        String tipusSensor = tipusArray.getString(j);
                        tipusSensorsList.add(SensorIndividual.Tipus.valueOf(tipusSensor));
                    }

                    SensorIndividual.Tipus[] tipusSensors = tipusSensorsList.toArray(new SensorIndividual.Tipus[0]);

                    // Crear sistema
                    SistemaMonitoratge.Usuari tipusUsuari = tipus.equalsIgnoreCase("domestic")
                            ? SistemaMonitoratge.Usuari.Domèstic
                            : SistemaMonitoratge.Usuari.Industrial;

                    SistemaMonitoratge sistema = new SistemaMonitoratge(tipusUsuari);
                    sistema.afegirDispositiu(nomDispositiu, tipusSensors);

                    return sistema;
                }
            }
        throw new IllegalArgumentException("Usuari no existeix");
    }
}
