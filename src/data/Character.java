package data;

import javafx.scene.CacheHint;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.of;

public class Character {
    public String name;
    public String imgPath;
    public Image img;
    public String id;

    private static final HashMap<String, Character> _characters = new HashMap<>(
            of(
                    "1", new Character("Character 1", "character1.png", "1"),
                    "2", new Character("Character 2", "character2.png", "2"),
                    "3", new Character("Character 3", "character3.png", "3"),
                    "4", new Character("Character 4", "character4.png", "4"),
                    "5", new Character("Character 5", "character5.png", "5")
            )
    );

    public Character(String name, String imgPath, String id) {
        this.name = name;
        this.imgPath = getClass().getResource("/assets/images/" + imgPath).toString();
        this.img = new Image(this.imgPath);
        this.id = id;
    }

    public static HashMap<String, Character> getCharacters() {
        return _characters;
    }
}
