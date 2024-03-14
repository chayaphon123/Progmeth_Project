package Actions;

public class SkillAction extends Action{
    private int manaCost;

    public SkillAction(String name, int manaCost) {
        super(name);
        this.manaCost = manaCost;
    }

    void execute(Character character) {
        // Check and consume mana.
        // Implement super action logic.
    }
}
