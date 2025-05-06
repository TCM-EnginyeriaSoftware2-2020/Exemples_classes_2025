package domini.PatroEstatsAmbSubEstats;

public abstract class Tapada implements IEstatCasella{
    @Override
    public IEstatCasella destapar() {
        return Destapada.getInstanciaUnica();
    }

    @Override
    public boolean isVisible() { return false;}
}
