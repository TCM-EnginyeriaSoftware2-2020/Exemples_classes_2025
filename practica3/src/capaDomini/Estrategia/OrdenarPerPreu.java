package capaDomini.Estrategia;

import capaDomini.AbstractProduct;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class OrdenarPerPreu implements IEstrategiaOrdenacio {
    private static OrdenarPerPreu instance = new OrdenarPerPreu();
    private OrdenarPerPreu(){}
    public static IEstrategiaOrdenacio getInstance(){ return instance;}
    @Override
    public void ordenar(List<AbstractProduct> abstractProducts) {
        Collections.sort(abstractProducts, Comparator.comparing(AbstractProduct::getPreu));
    }
}
