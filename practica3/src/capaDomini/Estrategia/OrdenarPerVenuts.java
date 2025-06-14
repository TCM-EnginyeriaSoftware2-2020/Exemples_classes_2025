package capaDomini.Estrategia;

import capaDomini.AbstractProduct;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class OrdenarPerVenuts implements IEstrategiaOrdenacio {
    private static OrdenarPerVenuts instance = new OrdenarPerVenuts();
    private OrdenarPerVenuts(){}
    public static IEstrategiaOrdenacio getInstance(){ return instance;}
    @Override
    public void ordenar(List<AbstractProduct> abstractProducts) {
        Collections.sort(abstractProducts, Comparator.comparing(AbstractProduct::getVenuts).reversed());
    }
}
