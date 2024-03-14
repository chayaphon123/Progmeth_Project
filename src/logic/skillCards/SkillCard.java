package SkillCards;
import Characters.Character;

public class SkillCard {
    private String effect;
    private int value;

    public SkillCard(String effect, int value) {
        this.effect = effect;
        this.value = value;
    }

    // Apply the effect of the skill card to a character
    public void applyEffect(Character character) {
        switch (effect) {
            case "Heal":
                character.heal(value);
                break;
            case "ManaBoost":
                character.setMana(character.getMana() + value);
                break;
            // Add more cases for different effects
        }
    }
}
