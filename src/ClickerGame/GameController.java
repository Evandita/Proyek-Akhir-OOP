package ClickerGame;

import java.util.List;

public class GameController {
    private static Game game = Game.getInstance();

    //Method
    //Menambah perolehan perklik, diakses ketika membeli item peningkat penghasilan.
    public static void addPointsPerClick(int pointsPerClick) {
        game.setPointsPerClick(game.getPointsPerClick() + pointsPerClick);
    }

    //mengupdate total social credit setiap kali screen diklik
    public static void click() {
        game.setPoints(game.getPoints() + game.getPointsPerClick());
        game.setTotalClicks(game.getTotalClicks() + 1);
        game.setCummulativePoints(game.getCummulativePoints() + game.getPointsPerClick());
    }

    public static void buyItem(int price) {
        game.setPoints(game.getPoints() - price);
        game.setTotalItems(game.getTotalItems() + 1);
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

    public static boolean questRequirements() {
        if (game.getCummulativePoints() >= Quests.quest_points && game.getTotalClicks() >= Quests.quest_click && game.getTotalItems() >= Quests.quest_item && game.getRenown() < 5) {
            return true;
        }
        return false;
    }

    public static void levelUp() {
        if (game.getRenown() < 5) {
            game.setRenown(game.getRenown() + 1);
        }
    }
    
}
