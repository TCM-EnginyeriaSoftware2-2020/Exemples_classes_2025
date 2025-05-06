package CapaDomini.Moneda;

public class MonedaNintendoDS implements IMoneda{

    private int valor;
    public MonedaNintendoDS(){
        this.valor = (int) Math.round(1+Math.random());}
    @Override
    public int agafarMoneda() {
        return this.valor;
    }

    @Override
    public String quiSoc() {
        return "Sóc una moneda de la nintendo DS";
    }
}
