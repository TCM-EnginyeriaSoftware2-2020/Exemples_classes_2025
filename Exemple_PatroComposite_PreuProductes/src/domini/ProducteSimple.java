package domini;

public class ProducteSimple extends ProducteAbstracte{
	
    public ProducteSimple (String name, double price, String brand) {
        super(name, price, brand);
    }

    @Override
	public boolean addProduct(ProducteAbstracte product) {
		return false;		
	}

}