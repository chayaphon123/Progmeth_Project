package Actions;

import Characters.Character;
import Characters.Estaasp;
import Interfaces.Attackable;
import Players.Player;

public class NormalAction extends Action{
    public NormalAction(String name, int manaCost) {
        super(name, manaCost);
    }
    public void execute(Player player, Character target) {
        if (player.consumeMana(manaCost) && name == "Balag Balag Balag!") {
            // Implement Normal action logic
            if (target instanceof Attackable) {
                ((Attackable) target).receiveDamage(35);
                if (target instanceof Poisonable && ((Poisonable) target).isPoisoned()) {
                    ((Poisonable) target).increasePoisonLevel();
                }
            }
        }
    }
}
