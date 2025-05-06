package CapaDomini.Factoria;

import CapaDomini.Cercle;
import CapaDomini.Figura;
import CapaDomini.Quadrat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FactoriaConcreta {
    public static final int QUADRAT = 0;
    public static final int CERCLE = 1;

    private FactoriaConcreta(){}
    public static Figura creaFigura(int tipus, int costat)
    {
        switch ( tipus){
            case QUADRAT:
                return new Quadrat(costat);
            case CERCLE:
                return new Cercle(costat);
            default:
                throw new RuntimeException("Tipus incorrecte");
        }
    }
    public static  Figura creaFigura( String tipus, int costat) {
        if( !tipus.startsWith("CapaDomini."))
            tipus = "CapaDomini."+tipus;
        try {
            Class laClasse = Class.forName(tipus);
            Constructor unConstructor = laClasse.getConstructor(int.class);
            Object obj = unConstructor.newInstance(costat);
            System.out.println("area: " + laClasse.getMethod("getArea").invoke(obj));
            laClasse.getMethod("Area").invoke(obj);


            return (Figura) obj;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("el tipus no és correcte"+ e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
