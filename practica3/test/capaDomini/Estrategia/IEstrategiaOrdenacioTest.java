package capaDomini.Estrategia;

import capaDomini.AbstractProduct;
import capaDomini.ProducteExtern;
import capaDomini.ProducteVenut;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IEstrategiaOrdenacioTest {

    @Test
    void getLabels() {
        // cal definir 3 etiquetes
        assertEquals(3, IEstrategiaOrdenacio.getLabels().length);
    }

    @Test
    void selecciona() {
        // cal definir 3 classes diferents
        IEstrategiaOrdenacio ordre0 = IEstrategiaOrdenacio.selecciona(0);
        IEstrategiaOrdenacio ordre1 = IEstrategiaOrdenacio.selecciona(1);
        IEstrategiaOrdenacio ordre2 = IEstrategiaOrdenacio.selecciona(2);
        assertNotEquals(ordre0, ordre1);
        assertNotEquals(ordre0, ordre2);
        assertNotEquals(ordre1, ordre2);
        // no ho faig perquè depen com ho heu implementat, però cal que cada opció correspongui amb l'etiqueta donada.
    }

    @Test
    void ordenarPerNom() {
        List<AbstractProduct> llista = new ArrayList<>();
        llista.add(new ProducteVenut(1,"Teclat", 29.99f, 15));
        llista.add(new ProducteExtern(2,"Monitor", 59.99f));

        OrdenarPerNom.getInstance().ordenar(llista);
        for (int i = 0; i < llista.size() - 1; i++) {
            String descActual = llista.get(i).getDescripcio();
            String descSeguent = llista.get(i + 1).getDescripcio();

            assertTrue(descActual.compareTo(descSeguent) <= 0);
        }
    }

    @Test
    void ordenarPerPreu() {
        List<AbstractProduct> llista = new ArrayList<>();
        llista.add(new ProducteVenut(1,"Teclat", 29.99f, 15));
        llista.add(new ProducteExtern(2,"Monitor", 19.99f));

        OrdenarPerPreu.getInstance().ordenar(llista);
        for (int i = 0; i < llista.size() - 1; i++) {
            float preuActual = llista.get(i).getPreu();
            float preuSeguent = llista.get(i + 1).getPreu();

            assertTrue(preuActual <= preuSeguent);
        }
    }

    @Test
    void ordenarPerVenuts() {
        List<AbstractProduct> llista = new ArrayList<>();
        llista.add(new ProducteVenut(1,"Teclat", 29.99f, 15));
        llista.add(new ProducteExtern(2,"Monitor", 59.99f));

        OrdenarPerVenuts.getInstance().ordenar(llista);
        for (int i = 0; i < llista.size() - 1; i++) {
            float actual = llista.get(i).getVenuts();
            float seguent = llista.get(i + 1).getVenuts();

            assertTrue(actual >= seguent);
        }
    }
}