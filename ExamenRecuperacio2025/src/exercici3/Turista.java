package exercici3;

// Classe que no implementa IParticipant (incompatible)
public class Turista {
    private String nom;
    private String idioma;

    public Turista(String nom, String idioma) {
        this.nom = nom;
        this.idioma = idioma;
    }

    public void gaudir(String activitat) {
        System.out.println(nom + " is enjoying the " + activitat + " speaking " + idioma + ".");
    }

    public boolean necessitaGuia() {
        return !idioma.equalsIgnoreCase("catalan") && !idioma.equalsIgnoreCase("spanish");
    }
}
