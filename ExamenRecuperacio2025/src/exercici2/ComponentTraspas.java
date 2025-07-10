package exercici2;

import java.util.List;

// Component comú
abstract class ComponentTraspas {
    protected double pes;
    protected double volum;
    protected boolean esFragil;

    public ComponentTraspas(double pes, double volum, boolean esFragil) {
        this.pes = pes;
        this.volum = volum;
        this.esFragil = esFragil;
    }

    public double getPesTotal() {
        return pes;
    }

    public double getVolumTotal() {
        return volum;
    }

    public boolean conteFragils() {
        return esFragil;
    }

    // Mètodes per afegir/eliminar només per composites (default: error)
    public boolean afegir(ComponentTraspas component) {
        return false;
    }

    public void eliminar(ComponentTraspas component) {
        throw new UnsupportedOperationException();
    }

    public List<ComponentTraspas> getContingut() {
        throw new UnsupportedOperationException();
    }
}
