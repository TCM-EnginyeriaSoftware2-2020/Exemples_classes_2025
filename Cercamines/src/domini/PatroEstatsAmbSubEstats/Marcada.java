package domini.PatroEstatsAmbSubEstats;


public final class Marcada extends Tapada {

    private static Marcada instanciaUnica = new Marcada();

    private Marcada()  {}

    public static IEstatCasella getInstanciaUnica() { return instanciaUnica;}

    @Override
    public IEstatCasella marcar() {
        throw new RuntimeException("Ja està marcada");
    }

    @Override
    public IEstatCasella desmarcar() {
        return Desmarcada.getInstanciaUnica();
    }

    @Override
    public boolean isMarcada() {
        return true;
    }
}
