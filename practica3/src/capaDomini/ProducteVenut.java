package capaDomini;

public class ProducteVenut extends AbstractProduct {
    public ProducteVenut(int id, String descripcio, float preu, int venuts) {
        super(id, descripcio, preu, venuts);
    }

    @Override
    public String toString() {
        return "Venut: " + super.toString();
    }
}
