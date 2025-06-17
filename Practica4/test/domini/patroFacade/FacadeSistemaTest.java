package domini.patroFacade;

import domini.patroComposite.SensorIndividual;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeSistemaTest {
    @Test
    void singleton() {
        // comprovem constructors siguin privats
        Constructor[] elsConstructors = FacadeSistema.class.getConstructors();
        for (Constructor unConstructor: elsConstructors) {
            assertTrue(Modifier.isPrivate(unConstructor.getModifiers()),
                    "Cal que tots els constructors siguin privats");
        }
        // en la meva solució he fet tots els membres estàtics
        Method[] elsMetodes = FacadeSistema.class.getDeclaredMethods();
        for( Method unMetode : elsMetodes){
            assertTrue(Modifier.isStatic(unMetode.getModifiers()),
                    "Cal que tots els mètodes siguin estàtics");
        }
    }


    @Test
    void obtenirLectures() throws IOException {
        assertThrows(IllegalArgumentException.class, ()-> FacadeSistema.obtenirLecturesActuals(789));

        assertDoesNotThrow( ()-> FacadeSistema.obtenirLecturesActuals(123));
        assertTrue( FacadeSistema.obtenirLecturesActuals(123).contains("menjador"));

        assertDoesNotThrow( ()-> FacadeSistema.obtenirLecturesActuals(456));
        assertTrue( FacadeSistema.obtenirLecturesActuals(456).contains("sala principal"));
    }

    @Test
    void obtenirHistoric() throws IOException {
        assertThrows(IllegalArgumentException.class, ()-> FacadeSistema.obtenirHistoric(789));

        assertDoesNotThrow( ()-> FacadeSistema.obtenirHistoric(123));
        assertTrue( FacadeSistema.obtenirHistoric(123).contains("menjador"));

        assertDoesNotThrow( ()-> FacadeSistema.obtenirHistoric(456));
        assertTrue( FacadeSistema.obtenirHistoric(456).contains("sala principal"));
    }

    @Test
    void afegirDispositiu() throws IOException {
        String nomDispositiu = "testDispositiu";
        SensorIndividual.Tipus[] sensors = {SensorIndividual.Tipus.Soroll, SensorIndividual.Tipus.Aigua};

        String unexpected = FacadeSistema.obtenirLecturesActuals(123);
        assertDoesNotThrow( ()->FacadeSistema.afegirDispositiu(123,nomDispositiu, sensors));
        assertNotEquals(unexpected, FacadeSistema.obtenirLecturesActuals(123));
        assertTrue(FacadeSistema.obtenirLecturesActuals(123).contains(nomDispositiu));
    }

    @Test
    void consellMedioAmbientals() throws IOException {
        assertThrows(IllegalArgumentException.class, ()-> FacadeSistema.consellMedioAmbientals(789));

        assertDoesNotThrow( ()-> FacadeSistema.consellMedioAmbientals(123));
        assertEquals(ConsellMedioAmbientals.get(SistemaMonitoratge.Usuari.Domèstic), FacadeSistema.consellMedioAmbientals(123));

        assertDoesNotThrow( ()-> FacadeSistema.consellMedioAmbientals(456));
        assertEquals(ConsellMedioAmbientals.get(SistemaMonitoratge.Usuari.Industrial), FacadeSistema.consellMedioAmbientals(456));
    }

}
