package domini;

import domini.StatePattern.IEstatZombi;

public class Zombi {

    private IEstatZombi estat;
    private int vida;
    private int posicio;

    public Zombi() {
        this.estat = IEstatZombi.getEstatInicial();
        this.vida = 3;
        this.posicio = 0;
    }

    public int getPosicio() { return posicio; }

    public IEstatZombi getEstat() {
        return this.estat;
    }

    public int getVida() {
        return this.vida;
    }

    public void rebreDany(int dany) {
        // primer actualitzem la vida i després invoquem la transició.
        this.vida -= dany;
        if( this.vida < 0 ) this.vida = 0;
        this.estat = this.estat.rebreDany(this.vida);
    }

    public void update(int posicioPersonatge) {
        // primer calculem la distància (valor positiu) i després invoquem la transició
        this.estat = this.estat.update(Math.abs(this.posicio - posicioPersonatge));
        // una vegada actualitzat l'estat, intentaríem moure i/o atacar.
        if( this.estat.isMoving()) this.move(posicioPersonatge);
        if( this.estat.isAttacking()) this.attack();
    }

    private void move(int posicioPersonatge){
        int direccio = 1;
        if( posicioPersonatge < this.posicio) direccio = -1;
        else if( posicioPersonatge == this.posicio) direccio = 0;
        this.posicio += direccio;
    }
    private void attack()
    {
        //TODO caldria tenir una classe Persontage per atacar
    }
}
