package exercici3;

public class AdapterTurista implements IParticipant{
    private Turista turista;

    public AdapterTurista(Turista turista) {
        this.turista = turista;
    }

    @Override
    public boolean participa(String activitat) {
        if (turista.necessitaGuia()) {
            System.out.println("Assignant guia per a " + activitat + "...");
        }
        turista.gaudir(activitat);
        return true;
    }
}
