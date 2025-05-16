package domini;

public abstract class ProducteAbstracte {
	
	protected String nom;
    protected double preu;
    protected String marca;

    public ProducteAbstracte (String name, double price, String brand) {
        this.nom = name;
        this.preu = price;
        this.marca = brand;
    }

    public String getMarca() {
		return marca;
	}
	
	public String getNom() {
        return nom;
    }   

    public double getPreu() {
        return preu;
    }
    public abstract boolean addProduct(ProducteAbstracte ram);
}