package Exercici1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestConjuntBasic {
    /* El conjunt bàsic és el mínim nombre de camins linealment independents
        = cobertura màxima = passem per totes les arrestes
     */

    // cami de 0 voltes amb preu negatiu
    @Test
    public void testPreuNegatiu(){
        assertEquals(0.00, CalcularPreuFinal.calcularPreuFinal(-1.00, 0), 0.00);
    }

    // cami de 0 voltes amb tipus incorrecte
    @Test
    public void testTipusIncorrecte(){
        assertThrows(IllegalArgumentException.class,()-> {CalcularPreuFinal.calcularPreuFinal(10.00, -1);});
    }

    // NOTA: el codi té un error i sempre farà dues voltes (i a vegades

    // cami de 2 voltes sense descompte pel tipus amb 44A false
    @Test
    public void testReduitSenseDescompte(){
        double preu = 100;
        int tipusIVA = CalcularPreuFinal.REDUIT;
        double expected = preu * ( 1 + CalcularPreuFinal.IVA[tipusIVA]);
        assertEquals(expected, CalcularPreuFinal.calcularPreuFinal(preu, tipusIVA), 0.001);
    }
    // cami de 2 voltes sense descompte pel tipus amb 44A false
    @Test
    public void testSuperreduitSenseDescompte(){
        double preu = 100;
        int tipusIVA = CalcularPreuFinal.SUPERREDUIT;
        double expected = preu * ( 1 + CalcularPreuFinal.IVA[tipusIVA]);
        assertEquals(expected, CalcularPreuFinal.calcularPreuFinal(preu, tipusIVA), 0.001);
    }

    // cami de 2 voltes sense descompte pel preu amb 44B false
    @Test
    public void testGeneralSenseDescompte(){
        double preu = 10;
        int tipusIVA = CalcularPreuFinal.GENERAL;
        double expected = preu * ( 1 + CalcularPreuFinal.IVA[tipusIVA]);
        assertEquals(expected, CalcularPreuFinal.calcularPreuFinal(preu, tipusIVA), 0.001);
    }

    // cami de 2 voltes amb descompte (detectarem l'error del codi)
    @Test
    public void testGeneralAmbDescompte(){
        double preu = 100;
        int tipusIVA = CalcularPreuFinal.GENERAL;
        double expected = preu * ( 1 + CalcularPreuFinal.IVA[tipusIVA]) * (1-CalcularPreuFinal.DESCOMPTE[0][1]);
        assertEquals(expected, CalcularPreuFinal.calcularPreuFinal(preu, tipusIVA), 0.001);
    }


}
