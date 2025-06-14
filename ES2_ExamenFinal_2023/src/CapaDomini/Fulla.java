package CapaDomini;

public final class Fulla implements IHeredeus {

	private String nom;
	private EnumTipusFulla herencia;
	
	public Fulla(String nom, EnumTipusFulla herencia) {
		this.nom = nom;
		this.herencia = herencia;
	}
	
	@Override
	public String getName() {
		return this.nom;
	}
	
	@Override
	public double quantsDiners() {
		return this.herencia.ordinal() * 1000000;
	}

	@Override
	public int quantesMansions() {
		if( this.herencia == EnumTipusFulla.UnaMansio ) return 1;
		return 0;
	}

	@Override
	public String toString() {
		return this.nom + " vol " + this.herencia.toString();
	}

	@Override
	public boolean equals(Object other) {
		if( other == null) return false;
		if( other instanceof IHeredeus && this.getName().equals(((IHeredeus) other).getName()))
			return true;
		return false;
	}

	
}
