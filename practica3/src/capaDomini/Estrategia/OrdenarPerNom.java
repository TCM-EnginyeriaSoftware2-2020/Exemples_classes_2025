package capaDomini.Estrategia;

import capaDomini.AbstractProduct;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class OrdenarPerNom implements IEstrategiaOrdenacio {
    private static OrdenarPerNom instance = new OrdenarPerNom();
    private OrdenarPerNom(){}
    public static IEstrategiaOrdenacio getInstance(){ return instance;}
    @Override
    public void ordenar(List<AbstractProduct> abstractProducts) {
        Collections.sort(abstractProducts, Comparator.comparing(AbstractProduct::getDescripcio));
    }
}
