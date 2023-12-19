package ClickerGame;

import java.util.List;

public class MCVDemo {
    /*public static void main(String[] args) {
        Character model = savedCharacter(); //access saved character
        CharacterView view = new CharacterView(); //create new view
        CharacterController controller = new CharacterController(model, view);
        controller.updateView();
        
        controller.setCharacterGold(50000);
        controller.updateView();
    }
    
    private static Character savedCharacter() {
        Character character = Character.getInstance();
        character.setName("Budi");
        character.setGold(10000);
        character.setDamage(3.33f);
        return character;
    }*/

    public static void main(String[] args) {
        String filepath = "src\\data\\test.txt";
        Game game = Game.getInstance();
        game.setPointsPerClick(1);
        GameController.save(filepath, game);
        game.setPointsPerClick(5);
        GameController.load(filepath, game);
        System.out.println(game.getPointsPerClick());
    }
}
