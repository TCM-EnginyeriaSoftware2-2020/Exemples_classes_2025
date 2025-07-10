package exercici1.statePattern;

public interface IState {
    IState preparar();
    IState enviar();
    IState iniciarTransit();
    IState lliurar();
    IState registrarAbsencia(int intentsFallits);
    IState registrarDireccioIncorrecta();
    IState actualitzarDireccio();
    IState caducarDireccioSenseCanvi();
    IState rebreDevolucio();
}
