package domini.PatroEstats;

public final class TapadaMarcada implements IEstatCasella{

    private static TapadaMarcada instanciaUnica = new TapadaMarcada();

    private TapadaMarcada()  {}

    public static IEstatCasella getInstanciaUnica() { return instanciaUnica;}

    @Override
    public IEstatCasella marcar() {
        throw new RuntimeException("Ja està marcada");
    }

    @Override
    public IEstatCasella desmarcar() {
        return TapadaDesmarcada.getInstanciaUnica();
    }

    @Override
    public IEstatCasella destapar() {
        return Destapada.getIntanciaUnica();
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean isMarcada() {
        return true;
    }
}
