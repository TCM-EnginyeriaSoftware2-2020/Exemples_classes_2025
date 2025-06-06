package domini.PatroEstats;

import domini.PatroEstatsAmbSubEstats.Desmarcada;

public final class Destapada implements IEstatCasella{
    private static Destapada intanciaUnica = new Destapada();
    private Destapada(){}

    public static Destapada getIntanciaUnica() {
        return intanciaUnica;
    }

    @Override
    public IEstatCasella marcar() {
        throw  new RuntimeException("Est� destapada");
    }

    @Override
    public IEstatCasella desmarcar() {
        throw  new RuntimeException("Est� destapada");
    }

    @Override
    public IEstatCasella destapar() {
        throw  new RuntimeException("Est� destapada");
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public boolean isMarcada() {
        throw  new RuntimeException("Est� destapada");
    }
}
