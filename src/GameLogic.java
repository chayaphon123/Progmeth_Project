import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Characters.Character;
import SkillCards.SkillCard;
import java.util.Random;

public class GameLogic {
    private List<Character> characters;
    private int manaPerTurn;

    public GameLogic(int manaPerTurn) {
        this.characters = new ArrayList<>();
        this.manaPerTurn = manaPerTurn;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void startTurn() {
        Random random = new Random();
        List<SkillCard> skillDeck = generateSkillDeck();

        // Allocate mana to each character and random skill card to each character.
        for (Character character : characters) {
            character.setMana(character.getMana() + manaPerTurn);

            // Draw a random skill card and apply its effect.
            SkillCard drawnCard = skillDeck.get(random.nextInt(skillDeck.size()));
            drawnCard.applyEffect(character);
        }

        // Example of performing actions.
        // This should be replaced with actual game logic, like user input.
        for (Character character : characters) {
            if (character.isAlive()) {
                character.performAction(character.getNormalAction()); // Example action
            }
        }

        // Check end game condition.
        if (isGameOver()) {
            System.out.println("Game Over. All characters are defeated.");
        }
    }

    // Additional methods to manage game state, can be added here.

    private List<SkillCard> generateSkillDeck() {
        // Here you would generate a list of SkillCards to be used in the game.
        // This is a placeholder showing how you might initialize this list.
        List<SkillCard> deck = new ArrayList<>();
        List<SkillCard> tempdeck = deck;
        tempdeck.add(new SkillCard("Heal", 20));
        tempdeck.add(new SkillCard("ManaBoost", 10));
        // Add more skill cards as needed.
        return tempdeck;
    }

    public boolean isGameOver(){
        if (characters.stream().noneMatch(Character::isAlive)){
            return true;
        }
        return false;
    }
}
