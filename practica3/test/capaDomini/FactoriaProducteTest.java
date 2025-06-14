package capaDomini;

import capaPersistencia.FontDadesExternes;
import capaPersistencia.IFontDades;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FactoriaProducteTest {

    @Test
    void getInstanciaUnica() {
        // comprovem constructors siguin privats
        Constructor[] elsConstructors = FactoriaProducte.class.getConstructors();
        for (Constructor unConstructor: elsConstructors) {
            assertFalse(unConstructor.isAccessible());
        }
        // comprovem que retorni una instancia
        assertTrue(FactoriaProducte.getInstanciaUnica() instanceof FactoriaProducte);
    }

    @Test
    void crearProducteVenut() {
        int id = (int) (Math.random()*10);
        String description = "test";
        float preu = (float) (Math.random()*200);
        int venuts = (int) (Math.random()*100);
        AbstractProduct prod = FactoriaProducte.getInstanciaUnica().crearProducte(id,description,preu,venuts);
        assertTrue(prod instanceof ProducteVenut);
        assertEquals(id, prod.getId());
        assertEquals(description, prod.getDescripcio());
        assertEquals(preu, prod.getPreu());
        assertEquals(venuts, prod.getVenuts());
    }

    @Test
    void crearProducteExtern() {
        int id = (int) (Math.random()*10);
        String description = "test";
        float preu = (float) (Math.random()*200);
        AbstractProduct prod = FactoriaProducte.getInstanciaUnica().crearProducte(id,description,preu);
        assertTrue(prod instanceof ProducteExtern);
        assertEquals(id, prod.getId());
        assertEquals(description, prod.getDescripcio());
        assertEquals(preu, prod.getPreu());
        assertEquals(0, prod.getVenuts());
    }

    @Test
    void crearLlistatProducte() {

        FontDadesExternes dades = FontDadesExternes.getInstanciaUnica();

    }

    @Test
    void crearLlistatProducteAmbFontDadesSimulada() {
        // creo una classe anònima per fer un test
        IFontDades fontSimulada = new IFontDades() {
            @Override
            public List<String[]> obtenirProductes() {
                return List.of(
                        new String[]{"1", "Teclat", "29.99", "15"}, //Producte Venut
                        new String[]{"2", "Monitor", "59.99"} //Producte Extern
                );
            }
            @Override
            public void actualitzarProductesVenuts(List<String[]> dadesModificades) {}
        };
        // invoquem la factoria
        List<AbstractProduct> prod = FactoriaProducte.getInstanciaUnica().crearProducte(fontSimulada);
        assertEquals(2,prod.);
        // comprovem el producte venut
        AbstractProduct prodVenut = prod.getFirst();
        assertTrue(prodVenut instanceof ProducteVenut);
        assertEquals(1, prodVenut.getId());
        assertEquals("Teclat", prodVenut.getDescripcio());
        assertEquals(29.99, prodVenut.getPreu());
        assertEquals(15, prodVenut.getVenuts());
        // comprovem el producte extern
        AbstractProduct prodExtern = prod.getLast();
        assertTrue(prodExtern instanceof ProducteExtern);
        assertEquals(2, prodExtern.getId());
        assertEquals("Monitor", prodExtern.getDescripcio());
        assertEquals(59.99, prodExtern.getPreu());
        assertEquals(0, prodExtern.getVenuts());

    }

}