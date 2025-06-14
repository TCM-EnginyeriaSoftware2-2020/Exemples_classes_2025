package Exercici3;

public class PersonaFulla extends AbstractPerson{

    public PersonaFulla( String nom, Genere elGenere, double salari)
    {
        super(nom, elGenere, salari);
    }
    @Override
    protected int[] getGenere() {
        int [] comptador = new int[Genere.values().length];
        comptador[this.elGenere.ordinal()] ++;
        return comptador;
    }
}
