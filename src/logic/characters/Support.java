package Characters;

import Actions.Action;
import Interfaces.Attackable;
import Interfaces.Buffable;
import Interfaces.Healable;

public class Support extends Character implements Attackable, Healable, Buffable {
    public Support(int hp, int mana) {
        super(hp,mana);
    }

    @Override
    public void performAction(Action action) {

    }

    @Override
    public void heal(int amount) {
        this.hp += amount;
        System.out.println("Support heals for " + amount + ".");
    }

    @Override
    public void buff(int amount) {
        System.out.println("Support provides a buff.");
    }

    public void performAction() {
        System.out.println("Support performs a normal action.");
    }

    public void performSuperAction() {
        System.out.println("Support performs a super action, consuming mana.");
        this.mana -= 20; // Example mana consumption
    }
}
