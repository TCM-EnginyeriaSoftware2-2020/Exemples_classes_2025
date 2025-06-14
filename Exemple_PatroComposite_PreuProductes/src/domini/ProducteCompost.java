package domini;

import java.util.ArrayList;
import java.util.List;

public class ProducteCompost extends ProducteAbstracte {
	private List<ProducteAbstracte> productes;

	public ProducteCompost(String name, double price, String brand) {
		super(name, price, brand);
		productes = new ArrayList<ProducteAbstracte>();
	}

	@Override
	public double getPreu() {
		double price = super.getPreu();// IMPORTANT
		for (ProducteAbstracte child : productes) {
			price += child.getPreu();
		}
		return price;
	}

	@Override
	public boolean addProduct(ProducteAbstracte nou) {
		if (!this.esPotAfegir(nou))// IMPORTANT !!!!!!! el producte �s compost
			return false;
		if( nou instanceof ProducteCompost && !((ProducteCompost) nou).esPotAfegir(this))
			return false;
		return this.productes.add(nou);
	}

	private boolean esPotAfegir(ProducteAbstracte nou) {
		if( nou == null) return false;
		if( nou == this) return false;
		for (ProducteAbstracte prod: productes) {
			if( prod == nou) return false;
			if( prod instanceof ProducteCompost && !((ProducteCompost) prod).esPotAfegir(nou))
				return false;
		}
		return true;
	}

}