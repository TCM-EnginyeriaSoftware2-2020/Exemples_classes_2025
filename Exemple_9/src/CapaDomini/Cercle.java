package CapaDomini;

public class Cercle extends Figura{
    public Cercle(int costat) {
        super(costat);
    }

    @Override
    public double getArea() {

        return Math.PI * this.costat * this.costat;
    }

    public static void Area(){ System.out.println("l'àrea d'un cercle és calcula multiplicant pi per radi al quadrat");}
}
