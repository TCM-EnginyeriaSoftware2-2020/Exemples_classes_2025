package domini.PatroEstats;

public final class TapadaDesmarcada implements IEstatCasella{

    private static TapadaDesmarcada instanciaUnica = new TapadaDesmarcada();
    private TapadaDesmarcada(){}

    public static TapadaDesmarcada getInstanciaUnica() {
        return instanciaUnica;
    }

    @Override
    public IEstatCasella marcar() {
        return  TapadaMarcada.getInstanciaUnica();
    }

    @Override
    public IEstatCasella desmarcar() {
        throw new RuntimeException("Ja estic desmarcada");
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
        return false;
    }
}
