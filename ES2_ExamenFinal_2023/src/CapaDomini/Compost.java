package CapaDomini;

import java.util.ArrayList;

public class Compost implements IHeredeus {

	private ArrayList<IHeredeus> llistatDescendents = new ArrayList<IHeredeus>();
	private static Compost millionari;
	private String nom;
	private double quantitatDiners;
	private int quantitatMansions;

	public Compost(double quantitatDiners, int quantitatMansions){
		this.nom = "senyor Burns";
		millionari = this;
		this.quantitatDiners = quantitatDiners;
		this.quantitatMansions = quantitatMansions;
	}

	public Compost(String nom) {
		this.nom = nom;
		this.quantitatDiners = 0;
		this.quantitatMansions = 0;
	}

	public void setimportHerencia(double importHerencia) {
		this.quantitatDiners = importHerencia;
	}

	public void establirHerencia() {
		double diners = millionari.quantitatDiners - millionari.quantsDiners();
		int count = millionari.comptarCompostos();
		diners = diners / count;
		millionari.repartirHerencia(diners);
	}

	private int comptarCompostos() {
		int count = 0;
		for (IHeredeus descendent : llistatDescendents) {
			if (descendent instanceof Compost) {
				count++;
				count += ((Compost) descendent).comptarCompostos();
			}
		}
		return count;
	}
	private void repartirHerencia(double diners) {
		for (IHeredeus descendent : llistatDescendents) {
			if (descendent instanceof Compost) {
				((Compost) descendent).setimportHerencia(diners);
				((Compost) descendent).repartirHerencia(diners);
			}
		}
	}

	public boolean add(IHeredeus nou) {
		// per facilitar el codi primer caldrà afegir els compostos i després afegir les fulles al compost.
		if( nou instanceof Compost && !((Compost) nou).llistatDescendents.isEmpty())
			return false;
		
		// necessitem comprovar a tots els heredeus
		if (this.contains(nou))
			return false;
		

		// comprovem si hi ha suficient diners
		double total = millionari.quantitatDiners;
		total -= nou.quantsDiners();
		if (total < millionari.quantsDiners())
			return false;

		// comprovem si hi ha suficientes mansions
		total = millionari.quantitatMansions;
		total -= nou.quantesMansions();
		if (total < millionari.quantesMansions())
			return false;

		// afegim al llistat
		return this.llistatDescendents.add(nou);
	}
	
	public boolean contains(IHeredeus nou)
	{
		for( IHeredeus descendent : this.llistatDescendents)
		{
			if( descendent.equals(nou) ) return true;
			if(descendent instanceof Compost && ((Compost) descendent).contains(nou))
				return true;
		}
		return false;
	}

	@Override
	public double quantsDiners() {
		double suma = this.quantitatDiners;
		if (millionari == this)
			suma = 0;
		for (IHeredeus descendent : llistatDescendents) {
			suma += descendent.quantsDiners();
		}
		return suma;
	}

	@Override
	public int quantesMansions() {
		int suma = 0;
		for (IHeredeus descendent : llistatDescendents) {
			suma += descendent.quantesMansions();
		}
		return suma;
	}

	@Override
	public String toString() {
		String familia;
		if (millionari == this)
			familia = this.nom + " reparteix una herencia de " + this.quantitatDiners + " i " + this.quantitatMansions
					+ " mansions";
		else
			familia = this.nom + " hereta " + this.quantitatDiners;

		for (IHeredeus descendent : llistatDescendents) {
			familia += "\n" + descendent.toString();
		}
		return familia;
	}

	@Override
	public String getName() {
		return this.nom;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other instanceof IHeredeus && this.getName().equals(((IHeredeus) other).getName()))
			return true;
		return false;
	}

}
