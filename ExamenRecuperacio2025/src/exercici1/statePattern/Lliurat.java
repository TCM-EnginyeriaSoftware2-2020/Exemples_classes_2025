package exercici1.statePattern;

public class Lliurat implements IState{
    //patró singleton
    private final static Lliurat instance = new Lliurat();
    private Lliurat(){}
    public static IState getInstance() {return instance;}

    @Override
    public IState preparar() { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState enviar() { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState iniciarTransit() { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState lliurar() { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState registrarAbsencia(int intentsFallits) { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState registrarDireccioIncorrecta() { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState actualitzarDireccio() { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("Comanda lliurada"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Comanda lliurada"); }
}
