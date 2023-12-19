package ClickerGame;

//class Quests
public class Quests {

    //fields
    public static int quest_click, quest_points, quest_item;

    public static void updateQuests(int level) {
        switch(level) {
            case 0:
                quest_click = 5;
                quest_points = 10;
                quest_item = 2;
                break;
            case 1:
                quest_click = 10;
                quest_points = 20;
                quest_item = 4;
                
                break;
            case 2:
                quest_click = 20;
                quest_points = 40;
                quest_item = 6;
                break;
            case 3:
                quest_click = 40;
                quest_points = 80;
                quest_item = 8;
                break;
            case 4:
                quest_click = 80;
                quest_points = 160;
                quest_item = 10;
                break;
            case 5:
                quest_click = 160;
                quest_points = 320;
                quest_item = 15;
                break;
        }
    }

}