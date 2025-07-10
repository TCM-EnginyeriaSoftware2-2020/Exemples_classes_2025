package exercici4;

public class BouBrausMiura extends Bou implements IBouBrau {

    public BouBrausMiura(String nom) {
        super(nom,720, 5.0, "negre", 30.0);
    }

    @Override
    public void envesteix() {
        System.out.println(nom + " envesteix amb feresa.");
    }
}
