package ClickerGame;

import java.util.*;

public class Inventory{
    public List<Item> items = new ArrayList<>();
    public int itemCount;
    public int capacity;

    //Menambah item jika belum melebihi kapasitas
    //Jika bisa return true, else false
    public boolean addItem(Item item){
        if(itemCount >= capacity){
            items.add(item);
            itemCount++;
            return true;
        }
        return false;
    }
    //Menghapus item dari inventory
    public boolean removeItem(Item item){
        for(Item temp : items){
            if(item == temp){
                items.remove(item);
                return true;
            }
        }
        return false;
    }
}
