package Actions;

import Characters.Character;
import Effects.Buff;
import Players.Player;

public class UltimateAction extends Action{
    public UltimateAction(String name, int manaCost) {
        super(name, manaCost);
    }
    public void execute(Player player, Character randomEnemy) {
        if (player.consumeMana(manaCost)) {
            // Implement Ultimate action logic
            applyBuffToAll(new Buff(15,15)); // This buffs all teammates.
            if (randomEnemy instanceof Paralyzable) {
                ((Paralyzable) randomEnemy).paralyze();
            }
        }
    }
}
