package ClickerGame;

//class Quests
public class Quests {

    //fields
    public int quest_click, quest_points, quest_item_1, quest_item_2, quest_item_3;
    public String quest_label;
    public static int level;

    public Quests(int level) {
        switch(level) {
            case 0:
                quest_click = 5;
                quest_points = 10;
                quest_item_1 = 2;
                quest_item_2 = 2;
                quest_item_3 = 2;
                quest_label = "Click 5 times!\nCollect 10 points!\nBuy item1 2 times!\nBuy item2 2 times\nBuy item3 2 times";
                break;
            case 1:
                quest_click = 10;
                quest_points = 20;
                quest_item_1 = 4;
                quest_item_2 = 4;
                quest_item_3 = 4;
                quest_label = "Click 10 times!\nCollect 20 points!\nBuy item1 4 times!\nBuy item2 4 times\nBuy item3 4 times";
                break;
            case 2:
                quest_click = 20;
                quest_points = 40;
                quest_item_1 = 6;
                quest_item_2 = 6;
                quest_item_3 = 6;
                quest_label = "Click 20 times!\nCollect 40 points!\nBuy item1 6 times!\nBuy item2 6 times\nBuy item3 6 times";
                break;
            case 3:
                quest_click = 40;
                quest_points = 80;
                quest_item_1 = 8;
                quest_item_2 = 8;
                quest_item_3 = 8;
                quest_label = "Click 40 times!\nCollect 80 points!\nBuy item1 8 times!\nBuy item2 8 times\nBuy item3 8 times";
                break;
            case 4:
                quest_click = 80;
                quest_points = 160;
                quest_item_1 = 10;
                quest_item_2 = 10;
                quest_item_3 = 10;
                quest_label = "Click 80 times!\nCollect 160 points!\nBuy item1 10 times!\nBuy item2 10 times\nBuy item3 10 times";
                break;
            case 5:
                quest_click = 160;
                quest_points = 320;
                quest_item_1 = 15;
                quest_item_2 = 15;
                quest_item_3 = 15;
                quest_label = "Click 160 times!\nCollect 320 points!\nBuy item1 15 times!\nBuy item2 15 times\nBuy item3 15 times";
                break;
        }
    }
}