import CapaAplicacio.*;

import CapaDomini.AbstractComponent;
import CapaDomini.ComponentCompost;
import CapaDomini.Mobles.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

import static org.junit.jupiter.api.Assertions.*;

class TestCase {

    private  static EFamily elEstil;
    private static IAbstractFactory laFactoria;

    @BeforeAll
    public static void setUp() throws Exception {
        elEstil = EFamily.Moderna;
        laFactoria = IAbstractFactory.getInstance(elEstil);
    }

    @Test
    public void testFactoriaModerna() throws Exception {
        IAbstractFactory laFactoria = IAbstractFactory.getInstance(EFamily.Moderna);
        assertTrue( laFactoria.createCadira() instanceof CadiraModern);
        assertEquals(CadiraModern.class, laFactoria.createCadira().getClass());
        assertEquals(TaulaModern.class, laFactoria.createTaula().getClass());
        assertEquals(SofaModern.class, laFactoria.createSofa().getClass());
    }


    @Test
    public void testFactoriaClassica() throws Exception {
        IAbstractFactory laFactoria = IAbstractFactory.getInstance(EFamily.Classica);
        assertEquals(CadiraClassic.class, laFactoria.createCadira().getClass());
        assertEquals(TaulaClassic.class, laFactoria.createTaula().getClass());
        assertEquals(SofaClassic.class, laFactoria.createSofa().getClass());
    }

    @Test
    public void testCompost() throws Exception {
        ComponentCompost casa = new ComponentCompost(100, EFamily.Moderna, Etipus.Casa);
        ComponentCompost cuina = new ComponentCompost(20, EFamily.Moderna, Etipus.Habitacio);
        ComponentCompost menjador = new ComponentCompost(25, EFamily.Moderna, Etipus.Habitacio);
        ComponentCompost dormitori = new ComponentCompost(20, EFamily.Moderna, Etipus.Habitacio);
        ComponentCompost lavabo = new ComponentCompost(15, EFamily.Moderna, Etipus.Habitacio);

        assertTrue( casa.add(cuina));
        assertTrue( casa.add(menjador));
        assertTrue( casa.add(dormitori));
        assertTrue( casa.add(lavabo));
        assertFalse( casa.add( new ComponentCompost(50,EFamily.Moderna,Etipus.Habitacio)), "habitació massa gran");

        assertDoesNotThrow(()->{testHabitacio(cuina);});
        assertDoesNotThrow(()->{testHabitacio(menjador);});
        assertDoesNotThrow(()->{testHabitacio(dormitori);});
        assertDoesNotThrow(()->{testHabitacio(lavabo);});
    }
    @Test
    public void testCompostCheckFailsCasa() {
        ComponentCompost casa = new ComponentCompost(100, EFamily.Moderna, Etipus.Casa);

        assertFalse(casa.add(null), "null");
        assertFalse(casa.add(casa), "same object");
        assertFalse(casa.add(new ComponentCompost(50, EFamily.Moderna, Etipus.Casa)), "casa dins de casa");
        assertFalse(casa.add(new ComponentCompost(150, EFamily.Moderna, Etipus.Habitacio)), "habitació massa gran");
        assertFalse(casa.add(new ComponentCompost(50, EFamily.Classica, Etipus.Habitacio)), "habitació d'un altre estil");
        assertFalse(casa.add(new TaulaModern()), "moble a la casa");
    }
    @Test
    public void testCompostCheckFailsHabitacio(){
        ComponentCompost habitacio = new ComponentCompost(100, EFamily.Moderna, Etipus.Habitacio);
        assertFalse( habitacio.add( new ComponentCompost(50,EFamily.Moderna,Etipus.Casa )), "casa dins una habitació");
        assertFalse( habitacio.add( new ComponentCompost(50,EFamily.Moderna,Etipus.Habitacio)), "habitació dins habitació");
        assertFalse( habitacio.add( new TaulaModern(150)), "moble molt gran");
        assertFalse( habitacio.add( new TaulaClassic()), "moble altre estil");
    }

    private void testHabitacio( ComponentCompost habitacio) throws Exception {
        IAbstractFactory laFactoria = IAbstractFactory.getInstance(habitacio.getStyle());
        assertTrue(habitacio.add((AbstractComponent) laFactoria.createCadira()));
        assertTrue(habitacio.add((AbstractComponent) laFactoria.createCadira()));
        assertTrue(habitacio.add((AbstractComponent) laFactoria.createTaula()));
        assertTrue(habitacio.add((AbstractComponent) laFactoria.createSofa()));
    }
}
