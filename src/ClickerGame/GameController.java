package ClickerGame;

import java.util.List;

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

    //save
    public static void save(String filepath, savedObjects obj) {
        FileHandling.writeToFile(filepath, obj);
    }

    //load
    public static void load(String filepath, savedObjects obj) {
        List<String> datas = FileHandling.readFromFile(filepath);
        obj.fromString(datas);
    }
}
