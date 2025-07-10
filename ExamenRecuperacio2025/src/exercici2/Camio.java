package exercici2;

import java.util.ArrayList;
import java.util.List;

class Camio extends Capsa {

    private static Camio instancia = new Camio(500, 30); // exemple de límits

    private Camio(double capacitatPes, double capacitatVolum) {
        super(capacitatPes, capacitatVolum);
    }
    public static Camio getInstancia() { return instancia; }

    @Override
    public boolean afegir(ComponentTraspas component) {
        if( component == null) return false;
        if( component == this) return false;
        if( component instanceof ObjectePetit ) return false;

        double pesPrevist = getPesTotal() + component.getPesTotal();
        double volumPrevist = getVolumTotal() + component.getVolumTotal();

        if (pesPrevist > capacitatPes || volumPrevist > capacitatVolum) return false;

        contingut.add(component);
        if( component.conteFragils() ) this.esFragil = true;
        return true;
    }

    @Override
    public String toString() {
        return "Camió [pes=" + getPesTotal() + ", volum=" + getVolumTotal() + ", fràgil=" + esFragil + "]";
    }
}
