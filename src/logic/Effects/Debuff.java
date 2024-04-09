package Effects;


//handle the Poisoned status effect
public class Debuff extends Effect{
    private boolean isPoisoned;
    private int poisonLevel;

    public Debuff() {
        this.isPoisoned = false;
        this.poisonLevel = 0;
    }

    // Method to apply poison effect
    public void applyPoison() {
        isPoisoned = true;
        poisonLevel = 1; // Start with level 1 poison
    }

    // Method to increment poison level
    public void incrementPoisonLevel() {
        if (poisonLevel < 3) {
            poisonLevel++;
        }
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }

    public int getPoisonLevel() {
        return poisonLevel;
    }

    public void setPoisonLevel(int poisonLevel) {
        this.poisonLevel = poisonLevel;
    }
}
