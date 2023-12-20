package ClickerGame;

import javax.swing.SwingUtilities;

public class MCVDemo {
<<<<<<< Updated upstream

    public static void main(String[] args) {
        String filepath = "src\\data\\game.txt";
        Game game = Game.getInstance();
        
        // load game
        GameController.load(filepath, game);
        System.out.println(game.toString());

        // play game
        SwingUtilities.invokeLater(() -> {
            GameView gameView = new GameView();
            gameView.setVisible(true);
=======
    public static void main(String[] args) {
        //Load saved data to game
        GameView.Data = Game.getInstance();
        GameController.load("src\\data\\test.txt", GameView.Data);
        Quests.updateQuests(GameView.Data.getRenown());

        SwingUtilities.invokeLater(() -> {
            GameView game = new GameView();
            game.setVisible(true);
>>>>>>> Stashed changes
        });
    }
}
