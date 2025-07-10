package exercici1.statePattern;

public class Devolut implements IState{

    //patró singleton
    private final static Devolut instance = new Devolut();
    private Devolut(){}
    public static IState getInstance() {return instance;}

    @Override
    public IState preparar() { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState enviar() { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState iniciarTransit() { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState lliurar() { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState registrarAbsencia(int intentsFallits) { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState registrarDireccioIncorrecta() { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState actualitzarDireccio() { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("Comanda retornada"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Comanda retornada"); }
}
