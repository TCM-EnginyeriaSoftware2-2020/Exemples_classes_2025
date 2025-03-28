package Domini;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumaPositiusTest {

    private  static SumaPositius obj;
    @BeforeAll
    static void setUp() {
        obj = new SumaPositius();
    }

    @Test
    void test_cami0voltes() {
        /* 0 voltes -> F <= 0
         *  sortida esperada 0
         */
        float esperat = 0;
        float retorn = obj.sumaPositius(null,-1,0);
        assertTrue(esperat == retorn);
        assertEquals(esperat, retorn);
        assertEquals(esperat, retorn, 0.01f);
    }

    @Test
    void testFail()
    {fail("això ha de donar un error");}

    @Test
    void test_cami1voltaPositiu()
    {
        /* camí de 1 volta sencera
         * entrada: F=1 C=1 v={{4}}
         * sortida: 4
         */
        float[][] v = {{4}};
        float retorn = obj.sumaPositius(v,v.length,v[0].length);
        assertTrue(v[0][0] == retorn);
        assertEquals(v[0][0], retorn);
        assertEquals(v[0][0], retorn, 0.01f);
    }

    @Test
    void test_cami1voltaNegatiu()
    {
        /* camí de 1 volta entro al primer while, però no al segon
         * entrada: F=1 C=1 v={{-1}}
         * sortida: -1
         */
        float[][] v = {{-1}};
        float esperat = 0;
        float retorn = obj.sumaPositius(v,v.length,v[0].length);
        assertTrue(esperat == retorn);
        assertEquals(esperat, retorn);
        assertEquals(esperat, retorn, 0.01f);
    }
}
