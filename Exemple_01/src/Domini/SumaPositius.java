package Domini;

public class SumaPositius {
    /*
     * L'objectiu del següent tros de codi és sumar els valors del array v,
     * mentre no trobi un valor negatiu.
     * Suposem que F és el nombre de files i C el nombre de columnes.
     */
    public float sumaPositius(float v[][], int F, int C) {
        float total = 0;
        int i, j;
        i = 0;
        while (i < F) {//1er while
            j = 0;
            while ((j < C) && (v[i][j] >= 0)) {//2on while
                total =+ v[i][j];
                j++;
            }//fi 2on while
            i++;
        }//fi 1er while
        return total;
    }//fi métode
}