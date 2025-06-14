package Exercici3;

import java.util.ArrayList;

public class PersonaComposta extends AbstractPerson{

    private ArrayList<AbstractPerson> membres = new ArrayList<>();

    public PersonaComposta(String nom, Genere elGenere, double salari)
    {
        super(nom, elGenere, salari);
    }
    @Override
    protected int[] getGenere() {
        int [] aux;
        int [] comptador = new int[Genere.values().length];
        comptador[this.elGenere.ordinal()] ++;
        for( AbstractPerson person : membres)
        {
            aux = person.getGenere();
            for(int index = 0; index < Genere.values().length; index++)
                comptador[index] += aux[index];
        }
        return comptador; //segur que hi ha una manera més eficient de fer-ho
    }

    @Override
    public double getSalari(){
        double total = this.salari;
        for( AbstractPerson person : membres)
            total += person.getSalari();
        return total;
    }

    public boolean add( AbstractPerson personaNova){
        if( personaNova == null) throw new IllegalArgumentException("persona nul.la");
        if( personaNova == this) throw new IllegalArgumentException("mateix objecte");
        if( this.contains(personaNova)) return false;
        return membres.add(personaNova);
    }

    private boolean contains(AbstractPerson personaNova)
    {
        if(membres.contains(personaNova)) return true;

        for( AbstractPerson person : membres)
            if(person instanceof PersonaComposta && ((PersonaComposta) person).contains(personaNova))
                return true;

        return false;
    }
}