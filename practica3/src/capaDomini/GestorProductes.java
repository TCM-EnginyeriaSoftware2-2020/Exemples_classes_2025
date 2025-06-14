package capaDomini;

import capaPersistencia.AdaptadorFontDadesExternes;
import capaPersistencia.FontDadesVenudes;

import java.util.List;

public class GestorProductes {
    private static GestorProductes instancia = null;
    private final List<AbstractProduct> abstractProducts;

    private GestorProductes() {
        FactoriaProducte fac = FactoriaProducte.getInstanciaUnica();
        abstractProducts = fac.crearProducte(FontDadesVenudes.getInstanciaUnica());
    }

    public static GestorProductes getInstance() {
        if (instancia == null) {
            instancia = new GestorProductes();
        }
        return instancia;
    }

    public void importarProductesExterns(){
        FactoriaProducte fac = FactoriaProducte.getInstanciaUnica();
        List<AbstractProduct> externs = fac.crearProducte(AdaptadorFontDadesExternes.getInstanciaUnica());
        for (AbstractProduct p : externs) {
            afegirProducte(p);
        }
    }

    public List<AbstractProduct> getProductes() {
        return abstractProducts;
    }

    public void afegirProducte(AbstractProduct nou) {
        if( !abstractProducts.contains(nou)) //contains executa equals
            abstractProducts.add(nou);
    }

    public void eliminarTots() {
        abstractProducts.clear();
    }
}
