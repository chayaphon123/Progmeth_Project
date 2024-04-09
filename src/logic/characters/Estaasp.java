package Characters;

import Actions.NormalAction;
import Actions.SkillAction;
import Actions.UltimateAction;
import Effects.Buff;
import Effects.Debuff;
import Interfaces.Attackable;
import Interfaces.Buffable;
import Interfaces.Healable;
import Players.Player;

public class Estaasp extends Character implements Attackable, Healable, Buffable  {
    // Attributes are already defined in the Character class

    public Estaasp() {
        super(200, 10, 12, 35, 20);
    }

    @Override
    public void receiveDamage(int damage) {
        this.setHp(this.getHp() - damage);
    }

    @Override
    public void applyBuff(Buff buff) {
        this.setAtk(this.getAtk() + buff.getAtkBoost());
        this.setMat(this.getMat() + buff.getMatBoost());
    }

    @Override
    public void heal(int amount) {
        this.setHp(this.getHp() + amount);
    }

    // Specific abilities as methods
    public void normalAbility(Character target, Player player) {
        new NormalAction("Balag Balag Balag!", 1).execute(player, target);
    }

    public void skillAbility(Character target, Player player) {
        new SkillAction("Potion or Poison? Guess it", 2).execute(player, target);
    }

    public void ultimateAbility(Team ourTeam, Character randomEnemy, Player player) {
        new UltimateAction("Mysterious Creation", 3).execute(player, ourTeam, randomEnemy);
    }

}
