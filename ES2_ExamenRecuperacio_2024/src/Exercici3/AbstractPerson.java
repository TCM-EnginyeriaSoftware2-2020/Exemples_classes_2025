package Exercici3;

public abstract class AbstractPerson {
    public enum Genere { Home, Dona, NoBinari, Fluid} //a l'examen es podia fer un booleà home/dona

    protected Genere elGenere;
    protected double salari;
    private final String nom;

    public AbstractPerson( String nom, Genere elGenere, double salari)
    {
        this.nom = nom;
        this.elGenere = elGenere;
        this.salari = salari;
    }

    public double getSalari(){ return this.salari;}

    protected abstract int[] getGenere(); // retornarà la quantitat de persones de cada gènere

    public String mostrarPercentatgeGenere()
    {
        String elRetorn = "";
        int[] comptador = this.getGenere();
        double sumaTotal = 0;
        for( int aux: comptador){sumaTotal += aux;}

        for( Genere unGenere : Genere.values())
            elRetorn += "Percentatge " + unGenere + ": " + comptador[unGenere.ordinal()] / sumaTotal * 100 + "% \n";
        return elRetorn;
    }
}
