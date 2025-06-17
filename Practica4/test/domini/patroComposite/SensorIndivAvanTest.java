package domini.patroComposite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorIndivAvanTest {

    @Test
    void obtenirLectura() {
        String nomSensor = "testSensor";
        SensorIndividual.Tipus tipusSensor = SensorIndividual.Tipus.Temperatura;
        SensorIndivAvan sensor = new SensorIndivAvan(nomSensor, tipusSensor);

        assertNotNull(sensor.obtenirLectura());
        assertTrue(sensor.obtenirLectura().contains(tipusSensor.name()));
    }

    @Test
    void obtenirHistoric() {
        String nomSensor = "testSensor";
        SensorIndividual.Tipus tipusSensor = SensorIndividual.Tipus.Temperatura;
        SensorIndivAvan sensor = new SensorIndivAvan(nomSensor, tipusSensor);

        assertNotNull(sensor.obtenirHistoric());
        assertTrue(sensor.obtenirLectura().contains(tipusSensor.name()));
    }
}