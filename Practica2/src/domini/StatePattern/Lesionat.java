package domini.StatePattern;

public class Lesionat extends AbstractEstat {
    // Aquesta classe no podem aplicar el patró singleton perquè cada zombi tindrà el seu "temps"
    private int cicles;

    public Lesionat(){ this.cicles = 3;}

    @Override
    public IEstatZombi update(int distancia) {
        this.cicles--;
        if (this.cicles <= 0)
            return Inactiu.getInstance();
        return this;
    }

}