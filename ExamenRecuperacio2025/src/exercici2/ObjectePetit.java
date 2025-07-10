package exercici2;

class ObjectePetit extends ComponentTraspas {

    public ObjectePetit(double pes, double volum, boolean esFragil) {
        super(pes, volum, esFragil);
    }

    @Override
    public String toString() {
        return "ObjectePetit [pes=" + pes + ", volum=" + volum + ", fràgil=" + esFragil + "]";
    }
}
