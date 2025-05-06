package CapaDomini;

public class Quadrat extends Figura
{
    public Quadrat(int costat) {
        super(costat);
    }

    @Override
    public double getArea() {
        return costat*costat;
    }
}
