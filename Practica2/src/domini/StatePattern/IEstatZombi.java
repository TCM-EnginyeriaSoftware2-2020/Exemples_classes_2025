package domini.StatePattern;

public interface IEstatZombi {

    public abstract IEstatZombi rebreDany( int vida);
    public abstract IEstatZombi update( int distancia );
    public abstract boolean isMoving();
    public abstract boolean isAttacking();

    public static IEstatZombi getEstatInicial(){
        return Inactiu.getInstance();
    }

}
