package capaDomini;

public class ProducteExtern extends AbstractProduct {

    public ProducteExtern(int id, String descripcio, float preu) {
        super(id, descripcio, preu, 0);
    }

    @Override
    public String toString() {
        return "Extern: " + super.toString();
    }

}