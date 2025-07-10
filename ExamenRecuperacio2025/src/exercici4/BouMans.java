package exercici4;

public class BouMans extends Bou implements IBouMans {
    public BouMans(String nom) {
        super(nom, 650, 2.5, "marró i blanc", 25.0);
    }

    @Override
    public void guia() {
        System.out.println(nom + " guia el grup de braus.");
    }
}
