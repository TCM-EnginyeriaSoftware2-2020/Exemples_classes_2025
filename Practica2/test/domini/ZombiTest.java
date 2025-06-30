package domini;

import domini.StatePattern.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZombiTest {
    private Zombi zombi1, zombi2;

    @BeforeEach
    public void setUp() {
        zombi1 = new Zombi();
        zombi2 = new Zombi();
    }

    @Test
    public void testInicial() {
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        assertEquals(0, zombi1.getPosicio());
        assertEquals(3, zombi1.getVida());

        assertInstanceOf(Inactiu.class, zombi2.getEstat());
        assertEquals(0, zombi2.getPosicio());
        assertEquals(3, zombi2.getVida());

        // donat el singleton tenen el mateix estat inactiu
        assertSame(zombi1.getEstat(), zombi2.getEstat());

        // si modifico un, l'altre no es modifica (cada zombi té el seu propi estat)
        zombi1.update(5);
        assertInstanceOf(Caminant.class, zombi1.getEstat());
        assertInstanceOf(Inactiu.class, zombi2.getEstat());
    }

    @Test
    public void testCaminantSingleton() {
        // caminant serà singleton
        zombi1.update(5);
        assertInstanceOf(Caminant.class, zombi1.getEstat());
        zombi2.update(5);
        assertInstanceOf(Caminant.class, zombi2.getEstat());
        assertSame(zombi1.getEstat(), zombi2.getEstat());
    }

    @Test
    public void testAtacantSingleton() {
        // atacant també serà singleton
        zombi1.update(1);
        assertInstanceOf(Atacant.class, zombi1.getEstat());
        zombi2.update(1);
        assertInstanceOf(Atacant.class, zombi2.getEstat());
        assertSame(zombi1.getEstat(), zombi2.getEstat());
    }

    @Test
    public void testDestruitSingleton() {
        // destruït també és singleton
        zombi1.rebreDany(5);
        assertInstanceOf(Destruit.class, zombi1.getEstat());
        zombi2.rebreDany(5);
        assertInstanceOf(Destruit.class, zombi2.getEstat());
        assertSame(zombi1.getEstat(), zombi2.getEstat());
    }

    @Test
    public void testLesionatNoSingleton() {
        // lesionat no és singleton, cal que cada zombi tingui el seu ritme
        zombi1.rebreDany(1);
        assertInstanceOf(Lesionat.class, zombi1.getEstat());
        zombi2.rebreDany(1);
        assertInstanceOf(Lesionat.class, zombi2.getEstat());
        assertNotSame(zombi1.getEstat(), zombi2.getEstat());
        while(  zombi1.getEstat() instanceof Lesionat){
            zombi1.update(100);
        }
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        assertInstanceOf(Lesionat.class, zombi2.getEstat());
    }

    @Test
    public void testPersonatgeEspasa() {
        // un personatge avança i ens ataca amb una espasa
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        zombi1.update(8);
        assertInstanceOf(Caminant.class, zombi1.getEstat());
        assertEquals(1,zombi1.getPosicio());
        zombi1.update(6);
        assertInstanceOf(Caminant.class, zombi1.getEstat());
        assertEquals(2,zombi1.getPosicio());
        zombi1.update(4);
        assertInstanceOf(Caminant.class, zombi1.getEstat());
        assertEquals(3,zombi1.getPosicio());
        zombi1.update(3);
        assertInstanceOf(Atacant.class, zombi1.getEstat());
        zombi1.rebreDany(10);
        assertTrue(zombi1.getVida() <= 0);
        assertInstanceOf(Destruit.class, zombi1.getEstat());
        assertThrows(RuntimeException.class, ()-> zombi1.rebreDany(1));
        assertThrows(RuntimeException.class, ()-> zombi1.update(1));
    }

    @Test
    public void testPersonatgeRifle() {
        // un personatge ens ataca amb un rifle
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        zombi1.update(15);
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        assertEquals(0, zombi1.getPosicio());
        zombi1.rebreDany(1);
        assertInstanceOf(Lesionat.class, zombi1.getEstat());
        assertEquals(2, zombi1.getVida());
        zombi1.rebreDany(10);
        assertTrue(zombi1.getVida() <= 0);
        assertInstanceOf(Destruit.class, zombi1.getEstat());
        assertThrows(RuntimeException.class, ()-> zombi1.rebreDany(1));
        assertThrows(RuntimeException.class, ()-> zombi1.update(1));
    }

    @Test
    public void testPersonatgeFuig() {
        // un personatge fuig corrent
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        zombi1.update(9);
        assertInstanceOf(Caminant.class, zombi1.getEstat());
        assertEquals(1, zombi1.getPosicio());
        zombi1.update(12);
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        assertEquals(3, zombi1.getVida());
    }

    @Test
    public void testZombiAtaca() {
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        zombi1.update(1);
        assertInstanceOf(Atacant.class, zombi1.getEstat());
        assertEquals(3, zombi1.getVida());
        // TODO si tinguéssim una classe Personatge podríem comprovar la seva vida.
    }

    @Test
    public void testLesionatEsRecupera() {
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        int vida = zombi1.getVida();
        int dany = (int) (Math.random() * vida);
        zombi1.rebreDany(dany);
        assertEquals(vida-dany, zombi1.getVida());
        assertInstanceOf(Lesionat.class, zombi1.getEstat());
        zombi1.update(1);
        assertInstanceOf(Lesionat.class, zombi1.getEstat());
        zombi1.update(3);
        assertInstanceOf(Lesionat.class, zombi1.getEstat());
        zombi1.update(5);
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
    }

    @Test
    public void testDestruit() {
        assertInstanceOf(Inactiu.class, zombi1.getEstat());
        int vida = zombi1.getVida();
        while (vida > 1 )
        {
            zombi1.rebreDany(1);
            assertInstanceOf(Lesionat.class, zombi1.getEstat());
            vida--;
            assertEquals(vida, zombi1.getVida());
        }
        zombi1.rebreDany(1);
        assertTrue(zombi1.getVida() <= 0);
        assertInstanceOf(Destruit.class, zombi1.getEstat());
        assertThrows(RuntimeException.class, ()-> zombi1.rebreDany(1));
        assertThrows(RuntimeException.class, ()-> zombi1.update(1));
    }
}
