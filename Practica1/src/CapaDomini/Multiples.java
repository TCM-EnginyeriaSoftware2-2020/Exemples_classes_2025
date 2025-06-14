package CapaDomini;

public class Multiples {
    public static int[] trobaTresMultiplesMinims(int divisor, int[] nombres) {
        if (nombres == null || divisor <= 0) {
            throw new IllegalArgumentException("Paràmetre d'entrada null o divisor no vàlid");
        }

        int[] resultats = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int count = 0;

        for (int i = 0; i < nombres.length && count < 3; i++) {
            if (nombres[i] >= 0 && nombres[i] % divisor == 0) {  // Comprova que sigui positiu i múltiple
                count++;
                if( nombres[i] < resultats[0] )
                    resultats[0] = nombres[i];
                else if (nombres[i] < resultats[1] )
                    resultats[0] = nombres[i];
                else if (nombres[i] < resultats[2] )
                    resultats[0] = nombres[i];
            }
        }

        if( count < 3)
            resultats = null; // Si no troba 3 múltiples, retorna null
        return nombres;
    }
}
