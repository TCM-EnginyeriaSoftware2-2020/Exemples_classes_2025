package domini.PatroEstatsAmbSubEstats;


public final class Desmarcada extends Tapada {

    private static Desmarcada instanciaUnica = new Desmarcada();
    private Desmarcada(){}

    public static Desmarcada getInstanciaUnica() {
        return instanciaUnica;
    }

    @Override
    public IEstatCasella marcar() {
        return  Marcada.getInstanciaUnica();
    }

    @Override
    public IEstatCasella desmarcar() {
        throw new RuntimeException("Ja estic desmarcada");
    }

    @Override
    public boolean isMarcada() {
        return false;
    }
}
