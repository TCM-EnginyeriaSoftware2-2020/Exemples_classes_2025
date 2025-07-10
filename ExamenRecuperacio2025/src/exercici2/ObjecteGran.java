package exercici2;

class ObjecteGran extends ComponentTraspas {

    public ObjecteGran(double pes, double volum) {
        super(pes, volum, false); // no es consideren fràgils
    }

    @Override
    public String toString() {
        return "ObjecteGran [pes=" + pes + ", volum=" + volum + "]";
    }
}
