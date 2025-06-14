package capaPersistencia;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdaptadorFontDadesExternesTest {

    @Test
    void testImplementaIFontDades() {
        assertTrue(IFontDades.class.isAssignableFrom(AdaptadorFontDadesExternes.class),
                "Cal que la classe adaptadora implementi la interfície IFontDades = objectiu");
    }
    @Test
    void patroSingleton() {
        // comprovem constructors siguin privats
        Constructor[] elsConstructors = AdaptadorFontDadesExternes.class.getConstructors();
        for (Constructor unConstructor: elsConstructors) {
            assertTrue(Modifier.isPrivate(unConstructor.getModifiers()),
                    "Cal que tots els constructors siguin privats");
        }
        // comprovem que retorni sempre la mateixa instància
        AdaptadorFontDadesExternes instancia1 = AdaptadorFontDadesExternes.getInstanciaUnica();
        AdaptadorFontDadesExternes instancia2 = AdaptadorFontDadesExternes.getInstanciaUnica();
        assertSame(instancia1, instancia2, "S'ha d'obtenir sempre la mateixa instància");
    }

    @Test
    void obtenirProductes() {
        List<String[]> adap = AdaptadorFontDadesExternes.getInstanciaUnica().obtenirProductes();
        List<String[]> extern = FontDadesExternes.getInstanciaUnica().obtenirProductes();

        // Comprovar que tenen la mateixa mida
        assertEquals(extern.size(), adap.size(), "Les dues llistes han de tenir la mateixa mida");

        // Comprovar que cada array és igual
        for (int i = 0; i < extern.size(); i++) {
            assertArrayEquals(extern.get(i), adap.get(i), "Els elements a la posició " + i + " han de ser iguals");
        }
    }

    @Test
    void actualitzarProductesVenuts() {
        AdaptadorFontDadesExternes adaptador = AdaptadorFontDadesExternes.getInstanciaUnica();
        assertThrows(RuntimeException.class,
                () -> adaptador.actualitzarProductesVenuts(List.of()),
                "No es poden modificar les dades externes");
    }
}