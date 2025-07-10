package exercici4;

public abstract class Bou {
    protected String nom;
    protected int pes; // en kg
    protected double velocitat; // en m/s
    protected String color;
    protected double midaVanyes; // en cm

    public Bou(String nom, int pes, double velocitat, String color, double midaVanyes) {
        this.nom = nom;
        this.pes = pes;
        this.velocitat = velocitat;
        this.color = color;
        this.midaVanyes = midaVanyes;
    }

    public void mostrarInfo() {
        System.out.println(this.getClass().getSimpleName() +
                " - Pes: " + pes + "kg, Velocitat: " + velocitat + " m/s, Color: " + color + ", Vanyes: " + midaVanyes + " cm");
    }
}
