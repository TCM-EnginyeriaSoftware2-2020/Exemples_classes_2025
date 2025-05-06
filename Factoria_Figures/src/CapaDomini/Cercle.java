package CapaDomini;

public class Cercle extends Figura{
    public Cercle(int radi) {
        super(radi);
    }

    @Override
    public double getArea() {
        return Math.PI * costat*costat;
    }
}
