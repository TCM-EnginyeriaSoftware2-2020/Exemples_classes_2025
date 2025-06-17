package domini.patroAbstractFactory;

import domini.patroComposite.DispositiuCompost;
import domini.patroComposite.SensorIndivAvan;
import domini.patroComposite.SensorIndividual;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FactoriaIndustrialTest {

    @Test
    void singleton() {
        // comprovem constructors siguin privats
        Constructor[] elsConstructors = FactoriaIndustrial.class.getConstructors();
        for (Constructor unConstructor: elsConstructors) {
            assertTrue(Modifier.isPrivate(unConstructor.getModifiers()),
                    "Cal que tots els constructors siguin privats");
        }
        // comprovem que retorni sempre la mateixa instància
        FactoriaIndustrial instancia1 = FactoriaIndustrial.getInstance();
        FactoriaIndustrial instancia2 = FactoriaIndustrial.getInstance();
        assertSame(instancia1, instancia2, "S'ha d'obtenir sempre la mateixa instància");
    }

    @Test
    void crearSensorIndividual() {
        String nom = "SensorTemperatura";
        SensorIndividual.Tipus tipus = SensorIndividual.Tipus.Temperatura;
        SensorIndivAvan sensor = (SensorIndivAvan) FactoriaIndustrial.getInstance().crearSensorIndividual(nom, tipus);
        assertNotNull(sensor);
        assertEquals(nom, sensor.getNom());
        assertNotNull(sensor.obtenirLectura());
        assertTrue(sensor.obtenirLectura().contains(tipus.name()));
        assertNotNull(sensor.obtenirHistoric());
        assertTrue(sensor.obtenirHistoric().contains(tipus.name()));
    }

    @Test
    void crearDispositiu() {
        String nom = "Dispositiu1";
        SensorIndividual.Tipus[] seleccio = {SensorIndividual.Tipus.Temperatura, SensorIndividual.Tipus.Aigua};
        DispositiuCompost dispositiu = FactoriaIndustrial.getInstance().crearDispositiu(nom, seleccio);

        assertNotNull(dispositiu);
        assertEquals(nom, dispositiu.getNom());
        assertNotNull(dispositiu.obtenirLectura());
        assertTrue(dispositiu.obtenirLectura().contains(seleccio[0].name()));
        assertTrue(dispositiu.obtenirLectura().contains(seleccio[1].name()));
        assertNotNull(dispositiu.obtenirHistoric());
        assertTrue(dispositiu.obtenirHistoric().contains(seleccio[0].name()));
        assertTrue(dispositiu.obtenirHistoric().contains(seleccio[1].name()));

    }

}