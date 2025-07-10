package exercici1.statePattern;

public class EnDevolucio implements IState{
    private final static EnDevolucio instance = new EnDevolucio();
    private EnDevolucio(){}
    public static IState getInstance() {return instance;}

    @Override
    public IState rebreDevolucio() {
        return Devolut.getInstance();
    }

    @Override
    public IState preparar() { throw new IllegalStateException("Comanda en procés de devolució"); }
    @Override
    public IState enviar() { throw new IllegalStateException("Comanda en procés de devolució"); }
    @Override
    public IState iniciarTransit() { throw new IllegalStateException("Comanda en procés de devolució"); }
    @Override
    public IState lliurar() { throw new IllegalStateException("Comanda en procés de devolució"); }
    @Override
    public IState registrarAbsencia(int intentsFallits) { throw new IllegalStateException("Comanda en procés de devolució"); }
    @Override
    public IState registrarDireccioIncorrecta() { throw new IllegalStateException("Comanda en procés de devolució"); }
    @Override
    public IState actualitzarDireccio() { throw new IllegalStateException("Comanda en procés de devolució"); }
    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("Comanda en procés de devolució"); }
}
