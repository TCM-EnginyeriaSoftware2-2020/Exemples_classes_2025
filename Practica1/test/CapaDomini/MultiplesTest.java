package CapaDomini;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplesTest {
    /* Conjunt Bàsic està representat per 4 camins:
     * dos camins de 0 voltes on 3A true i 3B true,
     * i dos camins que seran el camí H i un camí que passi per 10A false i 12 true
     * (que poden ser els camins G, F, E, D o C).
     * Conjunt de Casos de Prova = {camí A, camí B, camí H, camí C}
     * No passa res si el vostre Conjunt de Caos de Prova és diferent.
     */
    /* IMPORTANT:
     * A continuació es fa la prova unitària de tots els camins,
     * però només cal fer-ne els escollits al Conjunt de Casos de Prova
     */

    @Test
    public void test_camiA()
    {
        /* Camí A: 3A → 4 → 25
         * Entrada:
         * - divisor = 2
         * - nombres = null
         * sortida: IllegalArgumentException
         */
        int divisor = 2;
        assertThrows(IllegalArgumentException.class, ()->MultiplesCorrect.trobaTresMultiplesMinims(divisor,null));
    }

    @Test
    public void test_camiB()
    {
        /* Camí B: 3A → 3B → 4 → 25
         * Entrada:
         * - divisor = -1
         * - nombres = {}
         * sortida: IllegalArgumentException
         */
        int divisor = -1;
        int[] nombres = {};
        assertThrows(IllegalArgumentException.class, ()->MultiplesCorrect.trobaTresMultiplesMinims(divisor,nombres));
    }

    @Test
    public void test_camiC()
    {
        /* Camí C: 3A → 3B → 7-8 → 10A → 22 → 23 → 24 → 25
         * Entrada:
         * - divisor = 2
         * - nombres = {}
         * sortida: null
         */
        int divisor = 2;
        int[] nombres = {};
        assertNull(MultiplesCorrect.trobaTresMultiplesMinims(divisor,nombres));
        // aquí trobaríem un error: el que retorna.
    }

    @Test
    public void test_camiD()
    {
        /* Camí D: 3A → 3B → 7-8 → 10A → 10B → 11A → 10A → 22 → 23 → 24 → 25
         * Entrada:
         * - divisor = 2
         * - nombres = {-1}
         * sortida: null
         */
        int divisor = 2;
        int[] nombres = {-1};
        assertNull(MultiplesCorrect.trobaTresMultiplesMinims(divisor,nombres));
    }
    @Test
    public void test_camiE()
    {
        /* Camí E: 3A → 3B → 7-8 → 10A → 10B → 11A → 11B →10A →  22 → 23 → 24 → 25
         * Entrada:
         * - divisor = 2
         * - nombres = {3}
         * sortida: null
         */
        int divisor = 2;
        int[] nombres = {3};
        assertNull(MultiplesCorrect.trobaTresMultiplesMinims(divisor,nombres));
    }

    @Test
    public void test_camiF()
    {
        /* Camí F: 3A → 3B → 7-8 → 10A → 10B → 11A → 11B → 12 → 13 → 14 → 10A → 22 → 23 → 24 → 25
         * Entrada:
         * - divisor = 2
         * - nombres = {4}
         * sortida: null
         */
        int divisor = 2;
        int[] nombres = {4};
        assertNull(MultiplesCorrect.trobaTresMultiplesMinims(divisor,nombres));
        //aquest camí és molt inútil perquè no podem comprovar que es guarda realment a 14.
    }

    @Test
    public void test_camiG()
    {
        /* Camí G: 3A → 3B → 7-8 → 10A → 10B → 11A → 11B → 12 → 13 → 14 →
					     10A → 10B → 11A → 11B → 12 → 13 → 15 → 16 → 10A →  22 → 23 → 24 → 25
         * Entrada:
         * - divisor = 2
         * - nombres = {4,6}
         * sortida: null
         */
        int divisor = 2;
        int[] nombres = {4,6};
        assertNull(MultiplesCorrect.trobaTresMultiplesMinims(divisor,nombres));
        //aquest camí és molt inútil perquè no podem comprovar que es guarda realment a 14 i 16.
    }

    @Test
    public void test_camiH()
    {
        /* Camí H: 3A → 3B → 7-8 → 10A → 10B → 11A → 11B → 12 → 13 → 14 →
					     10A → 10B → 11A → 11B → 12 → 13 → 15 → 16 →
					     10A → 10B → 11A → 11B → 12 → 13 → 15 → 17 → 18 → 10A → 10B → 22 →  24 → 25
         * Entrada:
         * - divisor = 2
         * - nombres = {4,6,8}
         * sortida: null
         */
        int divisor = 2;
        int[] nombres = {8,4,6};
        int[] esperat = {4,6,8};
        assertArrayEquals(esperat, MultiplesCorrect.trobaTresMultiplesMinims(divisor,nombres));
        assertArrayEquals(esperat, MultiplesCorrect.trobaTresMultiplesMinims_opcio2(divisor,nombres));
        // aquí trobem errors, faig dues propostes de codi per arreglar-ho.
    }

}