package ejercici1;

public class Character {
    private final String name;
    private final int type;// 0= Archer, 1=Wizard, 2=Archer
    private int typeDefense; //0=shield, 1=dodge, 2=magic barrier

    public Character(String name, int type){
        this.name = name;
        this.type = type;
    }

    public void setDefense( int typeDefense ){ this.typeDefense = typeDefense;}

    public String getName() { return this.name; }

    public int getType() { return this.type; }

    public String attacking(){
        String aux = null;
        if( this.type == 0){
            aux = "Archer shoots an arrow";
        }else if( this.type == 1){
            aux = "Wizard casts a spell!";
        }else if( this.type == 2){
            aux = "Knight attacks with a sword!";
        }
        return aux;
    }

    public String defending(){
        String aux = null;
        switch (this.type){
            case 0: aux = "Archer is using a shield to defend!"; break;
            case 1: aux = "Wizard is creating a magic barrier for defense!"; break;
            case 2: if(typeDefense == 0) aux = "Knight is using a shield to defend!";
                    else if (typeDefense == 1) aux = "Knight is dodging to avoid attack!";
                    else if (typeDefense == 2) aux = "Knight is creating a magic barrier for defense!";
                    break;
            default: return null;
        }
        return aux;
    }
}
