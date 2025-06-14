package capaDomini;

import capaPersistencia.FontDadesExternes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GestorProductesTest {

    @BeforeEach
    void resetGestor() {
        // Important: Esborrem els productes abans de cada test per evitar interacció entre proves
        GestorProductes.getInstance().eliminarTots();
    }

    @Test
    void patroSingleton() {
        // comprovem constructors siguin privats
        Constructor[] elsConstructors = GestorProductes.class.getConstructors();
        for (Constructor unConstructor: elsConstructors) {
            assertTrue(Modifier.isPrivate(unConstructor.getModifiers()),
                    "Cal que tots els constructors siguin privats");
        }
        // comprovem que retorni sempre la mateixa instància
        GestorProductes instancia1 = GestorProductes.getInstance();
        GestorProductes instancia2 = GestorProductes.getInstance();
        assertSame(instancia1, instancia2, "S'ha d'obtenir sempre la mateixa instància");
    }

    @Test
    void importarProductesExterns() {
        GestorProductes gestor = GestorProductes.getInstance();
        List<AbstractProduct> llistat = gestor.getProductes();
        int size = llistat.size();
        List<String[]> extern = FontDadesExternes.getInstanciaUnica().obtenirProductes();
        // importem els productes externs
        gestor.importarProductesExterns();
        llistat = gestor.getProductes();
        assertEquals(size + extern.size(), llistat.size());

        //comprovem que s'han guardat
        for (int i = 0; i < extern.size(); i++) {
            int id = Integer.parseInt(extern.get(i)[0]);
            String nom = extern.get(i)[1];
            float preu = Float.parseFloat(extern.get(i)[2]);
            assertTrue(llistat.contains(new ProducteExtern(id, nom, preu)));
        }
    }

    @Test
    void getProductes() {
        List<AbstractProduct> productes = GestorProductes.getInstance().getProductes();
        assertNotNull(productes, "La llista de productes no pot ser nul·la");
    }

    @Test
    void afegirProducte() {
        //això no estava explicat a l'enunciat, però cal fer-ho per evitar duplicats.
        //cal implementar el mètode equals a la classe AbstractProduct que compari l'atribut id.
        GestorProductes gestor = GestorProductes.getInstance();
        List<AbstractProduct> llista = gestor.getProductes();
        int size = llista.size();
        //inserim un nou element
        int nouId = findID(llista, 1);
        AbstractProduct prod = new ProducteExtern(nouId, "Test", 1.0f);
        gestor.afegirProducte(prod);
        //comprovem que estigui
        llista = gestor.getProductes();
        assertEquals(size+1, llista.size());
        assertTrue(llista.contains(prod));
        //si intentem afegir per segon vegada no ho afegirà.
        gestor.afegirProducte(prod);
        llista = gestor.getProductes();
        assertEquals(size+1, llista.size());
        int count = 0;
        for (AbstractProduct item: llista) {
            if( item == prod) count++;
        }
        assertEquals(1, count, "No s'hauria de duplicar el producte");
    }

    private int findID(List<AbstractProduct> llista, int candidat) {
        for (AbstractProduct p : llista) {
            if (p.getId() == candidat) {
                return findID(llista, candidat + 1);
            }
        }
        return candidat;
    }


    @Test
    void eliminarTots() {
        GestorProductes.getInstance().eliminarTots();
        assertEquals(0, GestorProductes.getInstance().getProductes().size());
    }
}