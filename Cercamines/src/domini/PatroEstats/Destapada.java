package domini.PatroEstats;

public class Destapada implements IEstatCasella{
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
