package Exercici1;
/*
    A partir del preu d'una compra, primer afegirem l'IVA,
    i a continuació farem un únic descompte percentual si sobrepassa
    un cert llindar.
 */

public class CalcularPreuFinal {

    /* Existeixen tres tipus d'IVA:
        - general cal sumar un 21%.
        - reduït cal sumar un 10%.
        - superreduït cal sumar un 4%.
     */
    public static final int GENERAL = 0;
    public static final int REDUIT = 1;
    public static final int SUPERREDUIT = 2;

    public static final double[] IVA = {0.21,0.10,0.04};

    /* Tindrem dos tipus de descomptes que només s'aplicaran en el cas que el
       producte sigui d'IVA general:
        - si supera els 100 euros fem un 10% de descompte
        - altrament si supera els 50 euros fem un 5% de descompte
     */
    public static final double[][] DESCOMPTE = {{100.00, 0.10},{50.00,0.05}};

    public static double calcularPreuFinal(double preu, int tipusIVA)
    {
        if( preu <= 0) return 0.00;

        switch (tipusIVA)
        {
            case GENERAL:
            case REDUIT:
            case SUPERREDUIT:
                preu = preu * (1 + IVA[tipusIVA]);
                break;
            default:
                throw new IllegalArgumentException("Tipus d'iva incorrecte");
        }

        for (double[] unDescompte : DESCOMPTE)
            if (tipusIVA == GENERAL && preu > unDescompte[0])
                preu = preu * (1 - unDescompte[1]);

        return preu;
    }
}
