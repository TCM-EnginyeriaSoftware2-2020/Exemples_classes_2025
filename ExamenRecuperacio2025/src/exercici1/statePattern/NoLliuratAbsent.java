package exercici1.statePattern;

public class NoLliuratAbsent implements IState{
    //patró singleton
    private final static NoLliuratAbsent instance = new NoLliuratAbsent();
    private NoLliuratAbsent(){}
    public static IState getInstance() {return instance;}


    @Override
    public IState registrarAbsencia(int intentsFallits) {
        return this;
    }
    @Override
    public IState actualitzarDireccio() {
        return EnTransit.getInstance();
    }
    @Override
    public IState iniciarTransit() {
        return EnTransit.getInstance();
    }

    @Override
    public IState preparar() { throw new IllegalStateException("Absencia del comprador"); }
    @Override
    public IState enviar() { throw new IllegalStateException("Absencia del comprador"); }

    @Override
    public IState lliurar() { throw new IllegalStateException("Absencia del comprador"); }
    @Override
    public IState registrarDireccioIncorrecta() { throw new IllegalStateException("Absencia del comprador"); }

    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("Absencia del comprador"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Absencia del comprador"); }
}
