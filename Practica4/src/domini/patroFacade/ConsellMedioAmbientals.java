package domini.patroFacade;


public class ConsellMedioAmbientals {

    public static String get(SistemaMonitoratge.Usuari tipusUsuari) {
        String aux = "";
        if( tipusUsuari.ordinal() == 1) {
            aux = "1. Vigila el consum\n";
            aux += "2. Sigues exigent amb els teus proveïdors\n";
            aux += "3. La gestió de residus, obligatòria\n";
            aux += "4. Consciència a la teva gent\n";
            aux += "5. Mesura el teu impacte ambiental\n";
        }else {
            aux = "1. Estalviar aigua, llum i gas\n";
            aux += "2. Reduir, reutilitzar i reciclar\n";
            aux += "3. Consumir productes amb certificació ecològica\n";
            aux += "4. Evitar agafar el cotxe\n";
            aux += "5. No comprar productes d'un sol ús o envasats\n";
        }
        return aux;
    }
}
