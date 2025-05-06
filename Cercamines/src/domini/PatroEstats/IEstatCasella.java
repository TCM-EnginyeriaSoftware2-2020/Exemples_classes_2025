package domini.PatroEstats;

public interface IEstatCasella {


    public static IEstatCasella getEstatInicial(){
        return TapadaDesmarcada.getInstanciaUnica();
    }

    // 3 transicions (fletxes)
    public abstract IEstatCasella marcar();
    public abstract IEstatCasella desmarcar();
    public abstract IEstatCasella destapar();

    //addicionalment
    public abstract boolean isVisible();
    public abstract boolean isMarcada();

}
