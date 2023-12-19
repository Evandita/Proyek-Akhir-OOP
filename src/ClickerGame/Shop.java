package ClickerGame;

import java.util.*;

//Tempat membeli item untuk meningkatkan stat
public class Shop{
    public List<Item> items = new ArrayList<>();

    public Shop(){
        items.add(new Item("Social Media Influence Bot", Item.Rarity.COMMON, 1));
        items.add(new Item("Community Service Drone", Item.Rarity.COMMON, 1));
        items.add(new Item("Education Enhancement Course", Item.Rarity.COMMON, 5));
        items.add(new Item("Environmental Impact Tracker", Item.Rarity.COMMON, 5));
        items.add(new Item("Charity Event Sponsorship", Item.Rarity.COMMON, 10));

        items.add(new Item("Virtual Volunteer Network", Item.Rarity.UNCOMMON, 10));
        items.add(new Item("Cultural Exchange Program", Item.Rarity.UNCOMMON, 20));
        items.add(new Item("Health and Wellness App", Item.Rarity.UNCOMMON, 30));
        items.add(new Item("Thoughtful Gift Generator", Item.Rarity.UNCOMMON, 50));

        items.add(new Item("Social Responsibility Seminar", Item.Rarity.RARE, 50));
        items.add(new Item("Green Energy Investments", Item.Rarity.RARE, 100));
        items.add(new Item("Online Reputation Management Service", Item.Rarity.RARE, 200));

        items.add(new Item("Mindfulness Meditation App", Item.Rarity.EPIC, 500));
        items.add(new Item("Ethical Consumer Guide", Item.Rarity.EPIC, 1000));

        items.add(new Item("Community Feedback Platform", Item.Rarity.LEGENDARY, 2000));
        /*
                */
    }
}