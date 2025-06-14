package capaPersistencia;

import java.util.ArrayList;
import java.util.List;

public class FontDadesVenudes implements IFontDades {
    private static FontDadesVenudes instanciaUnica = new FontDadesVenudes();
    private FontDadesVenudes(){}

    public static FontDadesVenudes getInstanciaUnica() {
        return instanciaUnica;
    }

    @Override
    public List<String[]> obtenirProductes() {
        List<String[]> dades = new ArrayList<>();
        dades.add(new String[]{"201", "Auriculars Bluetooth", "49.99", "85"});
        dades.add(new String[]{"202", "Subscripció Premium", "9.99", "200"});
        return dades;
    }

    @Override
    public void actualitzarProductesVenuts(List<String[]> dadesModificades){

    }
}
