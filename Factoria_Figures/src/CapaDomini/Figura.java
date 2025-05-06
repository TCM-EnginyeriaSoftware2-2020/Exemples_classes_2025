package CapaDomini;

public abstract class Figura {
    protected int costat;
    public Figura ( int costat)
    { this.costat = costat;}

    public int getCostat() {
        return costat;
    }
    public abstract double getArea();
}
