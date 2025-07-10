package exercici1.statePattern;

public class Confirmat implements IState {
    //patró singleton
    private final static Confirmat instance = new Confirmat();
    private Confirmat(){}
    public static IState getInstance() {return instance;}

    @Override
    public IState preparar() {
        return EnPreparacio.getInstance();
    }

    @Override
    public IState enviar() { throw new IllegalStateException("Cal preparar abans d'enviar"); }
    @Override
    public IState iniciarTransit() { throw new IllegalStateException("Encara no s'ha enviat"); }
    @Override
    public IState lliurar() { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState registrarAbsencia(int intentsFallits) { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState registrarDireccioIncorrecta() { throw new IllegalStateException("Encara no en trànsit"); }
    @Override
    public IState actualitzarDireccio() { throw new IllegalStateException("Encara no es pot modificar l’adreça"); }
    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("No aplicable"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Encara no s’ha retornat res"); }
}

