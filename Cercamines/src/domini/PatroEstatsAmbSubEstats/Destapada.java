package domini.PatroEstatsAmbSubEstats;

public final class Destapada implements IEstatCasella {
    private static Destapada instanciaUnica = new Destapada();
    private Destapada(){}

    public static Destapada getInstanciaUnica() {
        return instanciaUnica;
    }

    @Override
    public IEstatCasella marcar() {
        throw  new RuntimeException("Està destapada");
    }

    @Override
    public IEstatCasella desmarcar() {
        throw  new RuntimeException("Està destapada");
    }

    @Override
    public IEstatCasella destapar() {
        throw  new RuntimeException("Està destapada");
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public boolean isMarcada() {
        throw  new RuntimeException("Està destapada");
    }
}
