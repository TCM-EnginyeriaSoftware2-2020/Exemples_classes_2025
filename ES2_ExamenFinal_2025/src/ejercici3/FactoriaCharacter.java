package ejercici3;

import ejercici2.AttackStrategy.CastSpell;
import ejercici2.AttackStrategy.ShootArrow;
import ejercici2.CharacterType.CharacterSimple;
import ejercici2.CharacterType.Knight;
import ejercici2.DefenseStrategy.CreateMagic;
import ejercici2.DefenseStrategy.Shield;

public class FactoriaCharacter {
    public static final int ARCHER = 0;
    public static final int WIZARD = 1;
    public static final int KNIGHT = 2;

    private FactoriaCharacter(){}
    /* Les factories concretes cal que siguin singleton,
     * en aquesta solució he impedit que es pugui fer cap instància
     * i tots els membres són estàtics. */
    public static CharacterSimple create(int type){
        switch (type){
            case ARCHER: return new CharacterSimple("Archer", ShootArrow.getInstance(), Shield.getInstance());
            case WIZARD: return new CharacterSimple("Wizard", CastSpell.getInstance(), CreateMagic.getInstance());
            case KNIGHT: return new Knight();
            default: throw new IllegalArgumentException("Tipus de personatge incorrecte");
        }
    }
    /* Aquest mètode es podria haver fet amb programació reflexiva,
       però no és necessària i dificultaria el testing i manteniment*/
}
