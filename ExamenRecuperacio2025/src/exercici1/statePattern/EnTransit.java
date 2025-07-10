package exercici1.statePattern;

public class EnTransit implements IState{
    //patró singleton
    private final static EnTransit instance = new EnTransit();
    private EnTransit(){}
    public static IState getInstance() {return instance;}

    @Override
    public IState lliurar() {
        return Lliurat.getInstance();
    }
    @Override
    public IState registrarAbsencia(int intentsFallits) {
        if( intentsFallits >= 3)
            return EnDevolucio.getInstance();
        return NoLliuratAbsent.getInstance();
    }
    @Override
    public IState registrarDireccioIncorrecta() {
        return new NoLliuratDireccioIncorrecta();
    }

    @Override
    public IState preparar() { throw new IllegalStateException("Ja s'ha preparat"); }
    @Override
    public IState enviar() { throw new IllegalStateException("Ja s'ha enviat"); }
    @Override
    public IState iniciarTransit() { throw new IllegalStateException("Estat actual"); }
    @Override
    public IState actualitzarDireccio() { throw new IllegalStateException("No es pot modificar l’adreça"); }
    @Override
    public IState caducarDireccioSenseCanvi() { throw new IllegalStateException("No aplicable"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Encara no s’ha retornat res"); }
}

