package domini.StatePattern;

/*  Donat que hi ha molt de codi repetit, es crea aquesta classe abstracte
    per evitar errors humans i facilitar el manteniment*/
public abstract class AbstractEstat implements IEstatZombi{
    @Override
    public IEstatZombi rebreDany(int vida) {
        if (vida <= 0)
            return Destruit.getInstance();
        return new Lesionat();
    }

    @Override
    public IEstatZombi update(int distancia) {
        if(distancia < 2) return Atacant.getInstance();
        if(distancia < 10) return Caminant.getInstance();
        return Inactiu.getInstance();
    }

    @Override
    public boolean isMoving() {
        return false; // per defecte no es mou
    }

    @Override
    public boolean isAttacking() {
        return false; // per defecte no ataca
    }
}
