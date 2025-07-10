package exercici1.statePattern;

public class Enviat implements IState{
    //patró singleton
    private final static Enviat instance = new Enviat();
    private Enviat(){}
    public static IState getInstance() {return instance;}

    @Override
    public IState iniciarTransit() {
        return EnTransit.getInstance();
    }

    @Override
    public IState preparar() { throw new IllegalStateException("Ja s'ha preparat"); }
    @Override
    public IState enviar() { throw new IllegalStateException("Estat actual"); }
    @Override
    public IState lliurar() { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState registrarAbsencia(int intentsFallits) { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState registrarDireccioIncorrecta() { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState actualitzarDireccio() { throw new IllegalStateException("No es pot modificar l’adreça"); }
    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("No aplicable"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Encara no s’ha retornat res"); }
}
