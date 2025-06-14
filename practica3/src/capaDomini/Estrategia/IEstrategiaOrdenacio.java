package capaDomini.Estrategia;

import capaDomini.AbstractProduct;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public interface IEstrategiaOrdenacio {

    public enum TipusOrdenacio {
        Ordenar_Per_Nom,
        Ordenar_Per_Preu,
        Ordenar_Per_Venuts;
    };

    public static String[] getLabels(){
        TipusOrdenacio[] items =  TipusOrdenacio.values();
        String[] labels = new String[items.length];
        for ( int i =0; i < items.length; i++) {
            labels[i] = items[i].name().replaceAll("_", " ");
        }
        return labels;
    }
    public static IEstrategiaOrdenacio selecciona(int opcioSeleccionada){
        // solució amb programació reflexiva
        TipusOrdenacio tipus = TipusOrdenacio.values()[opcioSeleccionada];
        String nom = "capaDomini.Estrategia."+tipus.name().replaceAll("_","");
        try {
            Class laClasse = Class.forName(nom);
            Method getInstance = laClasse.getMethod("getInstance");
            return  (IEstrategiaOrdenacio) getInstance.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract void ordenar(List<AbstractProduct> abstractProducts);
}
