package exercici2;

import java.util.ArrayList;
import java.util.List;

class Capsa extends ComponentTraspas {
    protected List<ComponentTraspas> contingut = new ArrayList<>();
    protected double capacitatPes;
    protected double capacitatVolum;

    public Capsa(double capacitatPes, double capacitatVolum) {
        super(0, 0, false); // el pes/volum inicial és 0, es calcula amb contingut
        this.capacitatPes = capacitatPes;
        this.capacitatVolum = capacitatVolum;
    }

    @Override
    public boolean afegir(ComponentTraspas component) {
        if( component == null) return false;
        if( ! (component instanceof ObjectePetit) ) return false;

        double pesPrevist = getPesTotal() + component.getPesTotal();
        double volumPrevist = getVolumTotal() + component.getVolumTotal();

        if (pesPrevist > capacitatPes || volumPrevist > capacitatVolum) return false;
        if( contingut.size() > 0 && (this.esFragil != component.conteFragils()) ) return false;

        contingut.add(component);
        // Actualitzem el flag de fràgil si cal
        this.esFragil = component.conteFragils();
        return true;
    }

    @Override
    public void eliminar(ComponentTraspas component) {
        contingut.remove(component);
    }

    @Override
    public double getPesTotal() {
        double pes = 0;
        for (ComponentTraspas item: contingut) {
            pes += item.getPesTotal();
        }
        return pes;
    }

    @Override
    public double getVolumTotal() {
        double volum = 0;
        for (ComponentTraspas item: contingut) {
            volum += item.getVolumTotal();
        }
        return volum;
    }

    @Override
    public boolean conteFragils() {
        return esFragil;
    }

    @Override
    public List<ComponentTraspas> getContingut() {
        return contingut;
    }

    @Override
    public String toString() {
        return "Capsa [pes=" + getPesTotal() + ", volum=" + getVolumTotal() + ", fràgil=" + esFragil + "]";
    }
}
