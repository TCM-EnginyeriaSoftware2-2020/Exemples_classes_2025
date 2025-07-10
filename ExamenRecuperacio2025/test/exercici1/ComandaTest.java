package exercici1;

import exercici1.statePattern.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComandaTest {

    @Test
    void fluxSenseIncidencies() {
        Comanda p = new Comanda("C/ Major 1, Mataró");
        assertInstanceOf(Confirmat.class, p.getEstat());
        p.preparar();
        assertInstanceOf(EnPreparacio.class, p.getEstat());
        p.enviar();
        assertInstanceOf(Enviat.class, p.getEstat());
        p.iniciarTransit();
        assertInstanceOf(EnTransit.class, p.getEstat());
        p.lliurar();
        assertInstanceOf(Lliurat.class, p.getEstat());
    }

    @Test
    void absentSegonIntentSEntrega() {
        Comanda p = new Comanda("C/ Major 1, Mataró");
        p.preparar();
        p.enviar();
        p.iniciarTransit();
        p.registrarAbsencia();          // 1r intent fallit
        assertInstanceOf(NoLliuratAbsent.class, p.getEstat());
        assertEquals(1, p.getIntentsFallits());
        p.iniciarTransit();            // 2n intent
        assertInstanceOf(EnTransit.class, p.getEstat());
        p.lliurar();                    // lliurat amb èxit
        assertInstanceOf(Lliurat.class, p.getEstat());
    }

    @Test
    void tresAbsenciesEsRetorna() {
        Comanda p = new Comanda("C/ Major 1, Mataró");
        p.preparar();
        p.enviar();
        p.iniciarTransit();
        p.registrarAbsencia(); // 1a absència
        assertInstanceOf(NoLliuratAbsent.class, p.getEstat());
        assertEquals(1, p.getIntentsFallits());

        // 2a absència
        p.iniciarTransit();
        p.registrarAbsencia();
        assertInstanceOf(NoLliuratAbsent.class, p.getEstat());
        assertEquals(2, p.getIntentsFallits());

        // 3a absència
        p.iniciarTransit();
        p.registrarAbsencia();
        assertInstanceOf(EnDevolucio.class, p.getEstat());

        // Arriba al magatzem
        p.rebreDevolucio();
        assertInstanceOf(Devolut.class, p.getEstat());
    }

    @Test
    void novaDireccioEnTermini() {
        Comanda p = new Comanda("C/ Major 1, Mataró");

        p.preparar();
        p.enviar();
        p.iniciarTransit();
        p.registrarDireccioIncorrecta();
        assertInstanceOf(NoLliuratDireccioIncorrecta.class, p.getEstat());
        assertEquals(1, p.getIntentsFallits());

        // Client informa nova adreça
        p.actualitzarDireccio("C/ Ernest Lluch 1, Mataró");
        assertInstanceOf(Enviat.class, p.getEstat());
        p.iniciarTransit();
        p.lliurar();
        assertInstanceOf(Lliurat.class, p.getEstat());
    }

    @Test
    void direccioIncorrectaCaducaAls3Dies() {
        Comanda p = new Comanda("C/ Major 1, Mataró");

        p.preparar();
        p.enviar();
        p.iniciarTransit();
        p.registrarDireccioIncorrecta();
        assertInstanceOf(NoLliuratDireccioIncorrecta.class, p.getEstat());

        // Passen 3 dies sense nova adreça
        p.caducarDireccioSenseCanvi();
        assertInstanceOf(EnDevolucio.class, p.getEstat());
        p.rebreDevolucio();
        assertInstanceOf(Devolut.class, p.getEstat());
    }


    @Test
    void controlCanviDireccio() {
        Comanda p = new Comanda("C/ Major 1, Mataró");

        // en preparació
        p.preparar();
        p.actualitzarDireccio("C/ Tordera 1, Mataró");
        assertInstanceOf(EnPreparacio.class, p.getEstat());

        p.enviar();
        assertThrows(IllegalStateException.class, () -> p.actualitzarDireccio("Fail"));
        p.iniciarTransit();
        assertThrows(IllegalStateException.class, () -> p.actualitzarDireccio("Fail"));

        // Forcem adreça incorrecta
        p.registrarDireccioIncorrecta();
        p.actualitzarDireccio("Passeig de Marina 1, Mataró"); // ha de permetre'l
        assertInstanceOf(Enviat.class, p.getEstat());

    }
}
