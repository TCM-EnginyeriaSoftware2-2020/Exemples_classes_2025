package capaPersistencia;

import java.util.List;

public interface IFontDades {
    List<String[]> obtenirProductes(); // Cada producte com a array [id, nom, preu, venuts, tipus]
    void actualitzarProductesVenuts(List<String[]> dadesModificades);
}
