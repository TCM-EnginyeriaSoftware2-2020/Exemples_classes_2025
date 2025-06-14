package capaPersistencia;

import java.util.List;

public final class AdaptadorFontDadesExternes implements IFontDades {
    private final FontDadesExternes font;
    private static AdaptadorFontDadesExternes instanciaUnica = new AdaptadorFontDadesExternes();

    public static AdaptadorFontDadesExternes getInstanciaUnica() {
        return instanciaUnica;
    }

    private AdaptadorFontDadesExternes() {
        this.font = FontDadesExternes.getInstanciaUnica();
    }

    @Override
    public List<String[]> obtenirProductes() {
        return this.font.obtenirProductes();
    }

    @Override
    public void actualitzarProductesVenuts(List<String[]> dadesModificades){
        throw new RuntimeException("No es poden modificar les dades externes");
    }
}
