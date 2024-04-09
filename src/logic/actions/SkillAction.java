package Actions;

import Characters.Character;
import Effects.Buff;
import Interfaces.Attackable;
import Interfaces.Buffable;
import Players.Player;

public class SkillAction extends Action{
    public SkillAction(String name, int manaCost) {
        super(name, manaCost);
    }

    public void execute(Player player, Character target) {
        if (player.consumeMana(manaCost)) {
            // Implement Skill action logic.
            if (target instanceof Buffable) {
                Buff buff = new Buff(20,20); // Assuming Buff constructor takes an effect size.
                ((Buffable) target).applyBuff(buff);
            }
            if (target instanceof Attackable && !(target instanceof Buffable)) {
                // Assuming Poisoned is a subclass of Debuff
                ((Attackable) target).applyDebuff(new Poisoned());
            }
        }
    }
}
