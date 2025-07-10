package exercici4;

public class BouBrausXXXX extends Bou implements IBouBrau {

    public BouBrausXXXX(String nom) {
        super(nom,600, 4.0, "marró", 60.0);
    }

    @Override
    public void envesteix() {
        System.out.println(nom + " envesteix amb feresa.");
    }
}
