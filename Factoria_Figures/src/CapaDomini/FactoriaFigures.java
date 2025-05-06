package CapaDomini;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FactoriaFigures {
    public static final int QUADRAT = 0;
    public static final int CERCLE = 1;
    private FactoriaFigures(){}
    public static Figura getFigura( int tipus, int costat){
        switch ( tipus ){
            case QUADRAT: return new Quadrat(costat);
            case CERCLE: return new Cercle(costat);
            default: throw new RuntimeException("Tipus no vàlid");
        }
    }
    public static Figura getFigura( String tipus, int costat)
    {
        if( !tipus.startsWith("CapaDomini."))
            tipus = "CapaDomini."+ tipus;
        try {
            Class laClasse = Class.forName(tipus);
            Constructor elConstructor =laClasse.getConstructor(int.class);
            Object obj = elConstructor.newInstance(costat);
            return (Figura) obj;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
