package ClickerGame;

public class GameController {
    Game game = Game.getInstance();

    //Method
    //Menambah perolehan perklik, diakses ketika membeli item peningkat penghasilan.
    public void addEarnings(double earnings) {
        game.setEarnings(game.getEarnings() + earnings);
    }

    //mengupdate total social credit setiap kali screen diklik
    public double click() {
        game.setcredit(game.getcredit() + game.getEarnings());
        return game.getEarnings();
    }
}
