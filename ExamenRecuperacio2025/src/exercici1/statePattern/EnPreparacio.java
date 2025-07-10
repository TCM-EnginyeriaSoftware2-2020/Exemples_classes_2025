package exercici1.statePattern;

public class EnPreparacio implements IState{
    //patró singleton
    private final static EnPreparacio instance = new EnPreparacio();
    private EnPreparacio(){}
    public static IState getInstance() {return instance;}
    @Override
    public IState enviar() {
        return Enviat.getInstance();
    }
    @Override
    public IState actualitzarDireccio() {
        return this;
    }
    @Override
    public IState preparar() { throw new IllegalStateException("Ja s'ha preparat"); }

    @Override
    public IState iniciarTransit() { throw new IllegalStateException("Encara no s'ha enviat"); }
    @Override
    public IState lliurar() { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState registrarAbsencia(int intentsFallits) { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState registrarDireccioIncorrecta() { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("No aplicable"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Encara no s’ha retornat res"); }
}
