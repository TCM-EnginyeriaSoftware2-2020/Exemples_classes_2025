package CapaDomini.Moneda;

public class MonedaGameBoy implements IMoneda{
    @Override
    public int agafarMoneda() {
        return 1;
    }

    @Override
    public String quiSoc() {
        return "Sóc una moneda de la game Boy";
    }
}
