package CapaPresentacio;

import CapaDomini.FactoriaFigures;
import CapaDomini.Figura;

public class Main {

    public static void main (String [] args) {
        int costat = 0, resposta = 2;
        Figura figura;
        FactoriaFigures factoria = new FactoriaFigures ();
        System.out.print ("De quina figura vols l'area CapaDomini.Quadrat=0, CapaDomini.Cercle=1, Sortir=2? ");
                resposta = Keyboard.readInt();
        while (resposta != 2) {
            if (resposta == 0 || resposta == 1){
                System.out.print ("Entre el valor del costat o radi: ");
                costat = Keyboard.readInt ();
                figura = factoria.getFigura (resposta, costat);
                System.out.println ("L'area és: " + figura.getArea());
            } // fi if
            else
                System.out.println ("Entre un 0, un 1 o un 2.");
            System.out.print ("De quina figura vols l'area CapaDomini.Quadrat=0, CapaDomini.Cercle=1, Sortir=2? ");
            resposta = Keyboard.readInt ();
        }// fi while
        System.out.print ("Adeu.");
    }
}
