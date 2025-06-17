package domini.patroComposite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispositiuCompostTest {
    @Test
    void afegir() {
        String nomSensor = "testSensor";
        SensorIndividual.Tipus tipusSensor = SensorIndividual.Tipus.Temperatura;
        SensorIndividual sensor = new SensorIndividual(nomSensor, tipusSensor);

        String nomDispositiu = "testDispositiu";
        DispositiuCompost dispositiu = new DispositiuCompost(nomDispositiu);

        assertFalse(dispositiu.afegir(null));
        assertFalse(dispositiu.afegir(dispositiu));
        assertTrue(dispositiu.afegir(sensor));
    }

    @Test
    void obtenirLectura() {
        String nomSensor = "testSensor";
        SensorIndividual.Tipus tipusSensor = SensorIndividual.Tipus.Temperatura;
        SensorIndividual sensor = new SensorIndividual(nomSensor, tipusSensor);

        String nomDispositiu = "testDispositiu";
        DispositiuCompost dispositiu = new DispositiuCompost(nomDispositiu);

        assertTrue(dispositiu.afegir(sensor));
        assertNotNull(dispositiu.obtenirLectura());
        assertTrue( dispositiu.obtenirLectura().contains(tipusSensor.name()));
    }

    @Test
    void obtenirHistoric() {
        String nomSensor = "testSensor";
        SensorIndividual.Tipus tipusSensor = SensorIndividual.Tipus.Temperatura;
        SensorIndivAvan sensor = new SensorIndivAvan(nomSensor, tipusSensor);

        String nomDispositiu = "testDispositiu";
        DispositiuCompost dispositiu = new DispositiuCompost(nomDispositiu);

        assertTrue(dispositiu.afegir(sensor));
        assertNotNull(dispositiu.obtenirHistoric());
        assertTrue(dispositiu.obtenirHistoric().contains(tipusSensor.name()));
    }
}