package ejercici2.CharacterType;

import ejercici2.AttackStrategy.SwingSword;
import ejercici2.DefenseStrategy.*;

public class Knight extends CharacterSimple{

    public Knight(){
        super("Knight", SwingSword.getInstance(), Shield.getInstance());
    }
    public void setDefense(int typeDefense /*0=shield, 1=dodge, 2=magic barrier*/){
        super.defense = IDefenseStrategy.selectDefense(typeDefense);
    }
}