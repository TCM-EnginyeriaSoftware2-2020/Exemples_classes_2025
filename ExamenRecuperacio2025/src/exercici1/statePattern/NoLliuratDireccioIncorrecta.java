package exercici1.statePattern;


import java.time.LocalDate;

public class NoLliuratDireccioIncorrecta implements IState{

    private LocalDate diaDetectatError;
    public NoLliuratDireccioIncorrecta(){
        diaDetectatError = LocalDate.now();
    }

    @Override
    public IState caducarDireccioSenseCanvi() {
        LocalDate avui = LocalDate.now();
        if( this.diaDetectatError.plusDays(3).isBefore(avui)){
            return EnDevolucio.getInstance();
        }
        return this;
    }
    @Override
    public IState registrarDireccioIncorrecta() {
        return this;
    }
    @Override
    public IState actualitzarDireccio() {
        return Enviat.getInstance();
    }
    @Override
    public IState iniciarTransit() { throw new IllegalStateException("Direcció del comprador incorrecte"); }
    @Override
    public IState preparar() { throw new IllegalStateException("Direcció del comprador incorrecte"); }
    @Override
    public IState enviar() { throw new IllegalStateException("Direcció del comprador incorrecte"); }
    @Override
    public IState lliurar() { throw new IllegalStateException("Direcció del comprador incorrecte"); }
    @Override
    public IState registrarAbsencia(int intentsFallits) { throw new IllegalStateException("Direcció del comprador incorrecte"); }
    @Override
    public IState rebreDevolucio() { throw new IllegalStateException("Direcció del comprador incorrecte"); }
}
