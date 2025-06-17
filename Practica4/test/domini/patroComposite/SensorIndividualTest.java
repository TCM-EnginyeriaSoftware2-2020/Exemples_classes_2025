package domini.patroComposite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorIndividualTest {

    @Test
    void obtenirLectura() {
        String nomSensor = "testSensor";
        SensorIndividual.Tipus tipusSensor = SensorIndividual.Tipus.Temperatura;
        SensorIndividual sensor = new SensorIndividual(nomSensor, tipusSensor);

        assertNotNull(sensor.obtenirLectura());
        assertTrue(sensor.obtenirLectura().contains(tipusSensor.name()));
    }

    @Test
    void obtenirHistoric() {
        String nomSensor = "testSensor";
        SensorIndividual.Tipus tipusSensor = SensorIndividual.Tipus.Temperatura;
        SensorIndividual sensor = new SensorIndividual(nomSensor, tipusSensor);

        assertNull(sensor.obtenirHistoric());
    }
}