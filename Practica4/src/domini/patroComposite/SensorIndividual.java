package domini.patroComposite;

import java.util.HashMap;
import java.util.Map;

public class SensorIndividual implements ISensor {

    private static final int[][] RANGEVALUES = new int[][]{{10, 35},{30,60},{0,40},{0,100}};
    public enum Tipus { Temperatura, Humitat, Soroll, Aigua};
    private final String nom;
    protected final Tipus tipus;
    protected double lectura;

    public SensorIndividual(String nom, Tipus tipus) {
        this.nom = nom;
        this.tipus = tipus;
        this.lectura = Math.round(RANGEVALUES[tipus.ordinal()][0] + RANGEVALUES[tipus.ordinal()][1] * Math.random() * 100) / 100;
    }

    public double getLectura() {
        this.lectura += Math.round( ( -5 + 10 * Math.random()) * 100) / 100;
        return this.lectura;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String obtenirLectura() {
        return tipus.name()+": "+ lectura;
    }

    @Override
    public String obtenirHistoric() {
        return obtenirLectura();
    }
}
