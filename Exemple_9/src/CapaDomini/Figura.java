package CapaDomini;

public abstract class Figura {
    protected int costat;

    public Figura( int costat)
    {this.costat = costat;}

    public abstract double getArea();
}
