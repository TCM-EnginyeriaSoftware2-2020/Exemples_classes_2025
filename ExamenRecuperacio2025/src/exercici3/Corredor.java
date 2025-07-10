package exercici3;

public class Corredor implements IParticipant{
    private String nom;

    public Corredor(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean participa(String activitat) {
        if (activitat.equalsIgnoreCase("encierro")) {
            System.out.println(nom + " està corrent a l'encierro!");
            return true;
        } else {
            System.out.println(nom + " no participa en " + activitat + ".");
            return false;
        }
    }
}
