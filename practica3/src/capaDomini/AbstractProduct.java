package capaDomini;

import java.util.Comparator;

public abstract class AbstractProduct {
    private final int id;
    private String descripcio;
    private float preu;
    private int venuts;

    public AbstractProduct(int id, String descripcio, float preu, int venuts) {
        this.id = id;
        this.descripcio = descripcio;
        this.preu = preu;
        this.venuts = venuts;
    }

    public int getId() {
        return id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public int getVenuts() {
        return venuts;
    }

    public void addVenuts(int newVenuts) {
        this.venuts += newVenuts;
    }

    @Override
    public String toString() {
        return String.format("ID: %d - %s - %.2f € - Venuts: %d", id, descripcio, preu, venuts);
    }

    @Override
    public boolean equals( Object other){
        if( other == null) return false;
        if( ! (other instanceof AbstractProduct)) return false;
        return this.id == ((AbstractProduct)other).id;
    }
}
