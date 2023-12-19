package ClickerGame;

import javax.swing.SwingUtilities;

public class MCVDemo {

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
        });
    }
}
