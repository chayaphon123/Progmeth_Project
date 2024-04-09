package Actions;


import Characters.Character;
import Players.Player;

// Action classes
public abstract class Action {
    protected String name;
    protected int manaCost;

    public Action(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;
    }

    public abstract void execute(Player player, Character target);
}
