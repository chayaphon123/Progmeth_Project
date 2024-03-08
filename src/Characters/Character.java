package Characters;

import Actions.Action;
import Interfaces.Attackable;
import Interfaces.Buffable;
import Interfaces.Healable;

public abstract class Character implements Attackable, Healable, Buffable {
    protected int hp;
    protected int mana;

    protected Action normalAction;

    protected Action superAction;

    public Character(int hp, int mana){
        this.hp = hp;
        this.mana = mana;
    }

    public abstract void performAction(Action action);

    public boolean isAlive(){
        return this.hp > 0;
    }

    @Override
    public void takeDamage(int amount) {
        this.hp -= amount;
        System.out.println(getClass().getSimpleName() + " took " + amount + " damage.");
    }

    @Override
    public void heal(int amount) {
        this.hp += amount;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Action getNormalAction() {
        return normalAction;
    }

    public void setNormalAction(Action normalAction) {
        this.normalAction = normalAction;
    }

    public Action getSuperAction() {
        return superAction;
    }

    public void setSuperAction(Action superAction) {
        this.superAction = superAction;
    }
}

