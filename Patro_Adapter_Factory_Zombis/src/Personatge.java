public class Personatge {

    /* Aquesta classe la pots millorar per tal de demanar a l'usuari el moviment*/

    private int posicio;
    private int vida;

    public Personatge( int posicio)
    {
        this.vida = 5;
        this.posicio = posicio;
    }
    public int getPosicio() {
        return posicio;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int dany) {
        this.vida -= dany;
        if( this.vida < 0 ) this.vida = 0;
    }
    public void setPosicio(int posicio) {
        this.posicio = posicio;
    }
}
