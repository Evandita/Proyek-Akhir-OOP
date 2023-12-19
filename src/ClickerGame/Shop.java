package ClickerGame;

import java.util.*;

//Tempat membeli item untuk meningkatkan stat
public class Shop{
    public List<Item> items = new ArrayList<>();

    public Shop(){
        items.add(new Item("Clicker Upgrade", 20, 1));
        items.add(new Item("Clicker Plus", 95, 5));
        items.add(new Item("Clicker Premium", 180, 10));
        items.add(new Item("Clicker Deluxe", 340, 20));
        items.add(new Item("Clicker Pro", 640, 40));
        items.add(new Item("Clicker Pro Max", 1200, 80));
    }
}