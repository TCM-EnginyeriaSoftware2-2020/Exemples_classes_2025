package domini.patroAbstractFactory;

import domini.patroComposite.DispositiuCompost;
import domini.patroComposite.SensorIndividual;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoriaDomesticaTest {
    @Test
    void singleton() {
        // comprovem constructors siguin privats
        Constructor[] elsConstructors = FactoriaDomestica.class.getConstructors();
        for (Constructor unConstructor: elsConstructors) {
            assertTrue(Modifier.isPrivate(unConstructor.getModifiers()),
                    "Cal que tots els constructors siguin privats");
        }
        // comprovem que retorni sempre la mateixa instància
        FactoriaDomestica instancia1 = FactoriaDomestica.getInstance();
        FactoriaDomestica instancia2 = FactoriaDomestica.getInstance();
        assertSame(instancia1, instancia2, "S'ha d'obtenir sempre la mateixa instància");
    }

    @Test
    void crearSensorIndividual() throws NoSuchFieldException {
        String nom = "SensorTemperatura";
        SensorIndividual.Tipus tipus = SensorIndividual.Tipus.Temperatura;
        SensorIndividual sensor = FactoriaDomestica.getInstance().crearSensorIndividual(nom, tipus);

        assertNotNull(sensor);
        assertEquals(nom, sensor.getNom());
        assertNotNull(sensor.obtenirLectura());
        assertTrue(sensor.obtenirLectura().contains(tipus.name()));
        assertNull(sensor.obtenirHistoric());
    }

    @Test
    void crearDispositiu() {
        String nom = "Dispositiu1";
        SensorIndividual.Tipus[] seleccio = {SensorIndividual.Tipus.Temperatura, SensorIndividual.Tipus.Aigua};
        DispositiuCompost dispositiu = FactoriaDomestica.getInstance().crearDispositiu(nom, seleccio);

        assertNotNull(dispositiu);
        assertEquals(nom, dispositiu.getNom());
        assertNotNull(dispositiu.obtenirLectura());
        assertTrue(dispositiu.obtenirLectura().contains(seleccio[0].name()));
        assertTrue(dispositiu.obtenirLectura().contains(seleccio[1].name()));
        assertNotNull(dispositiu.obtenirHistoric());
        assertTrue(dispositiu.obtenirHistoric().contains(nom));
    }

}