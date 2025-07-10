package exercici3;

// Programa principal
import java.util.*;

public class FestaSantFermi {
    public static void main(String[] args) {
        List<IParticipant> participants = new ArrayList<>();

        participants.add(new Corredor("Joan"));
        participants.add(new Espectador("Marta"));
        participants.add(new AdapterTurista(new Turista("Alice", "English")));
        participants.add(new AdapterTurista(new Turista("Pau", "Spanish")));

        for (IParticipant p : participants) {
            p.participa("encierro");
        }

        System.out.println("---");

        for (IParticipant p : participants) {
            p.participa("concert");
        }
    }
}
