package exercici3;

public class Espectador implements IParticipant{
    private String nom;

    public Espectador(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean participa(String activitat) {
        if (activitat.equalsIgnoreCase("concert")) {
            System.out.println(nom + " té entrada pel concert!");
            return true;
        } else if (activitat.equalsIgnoreCase("plaça")) {
            System.out.println(nom + " observa des de les grades de la plaça de toros");
            return true;
        } else {
            System.out.println(nom + " no participa en " + activitat + ".");
            return false;
        }
    }
}
