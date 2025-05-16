package domini;

import java.util.ArrayList;
import java.util.List;

public class ProducteCompost extends ProducteAbstracte {

	private List<ProducteAbstracte> productes;
	private static boolean repe= false;

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
	public boolean addProduct(ProducteAbstracte product) {	
		if (esPotAfegir(product))// IMPORTANT !!!!!!! el producte és compost
			return this.productes.add(product);
		return false;
	}

	private boolean esPotAfegir(ProducteAbstracte product) {		
		if (product == null)//no afegim productes nuls
			return false;
		if (product == this)//no podem afgir el this
			return false;	
		if (product instanceof ProducteCompost) {
			repe = false; //atribut static
			if (esRepetit (product)) return false;//si el product és compost i ja hi és en el this, no es pot afegir
			ProducteCompost pc = (ProducteCompost) product;
			if (pc.esRepetit (this)) return false;//Mirem recursivament que en el product no hi sigui this
		}
		return true;//els productes simples poden estar repetits
	}
	
	private boolean esRepetit (ProducteAbstracte product) {
		for (ProducteAbstracte child : productes) {
			if (child == product) {
				repe = true;
				return repe;
			}
			if (child instanceof ProducteCompost && !repe) {
				((ProducteCompost) child).esRepetit(product);
			}
		}
		return repe;
	}
}