package ClickerGame;

//Type Item
public class Item{
    
    private String name;
    private int level;
    private int price;
    private int pointsIncrease;

    //Constructor
    public Item(String name, int price, int pointsIncrease){
        this.name = name;
        this.level = 1;
        this.price = price;
        this.pointsIncrease = pointsIncrease;
    }

    //Setter
    public void setName(String name){
        this.name = name;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setPointsIncrease(int pointsIncrease){
        this.pointsIncrease = pointsIncrease;
    }
    //Getter
    public String getName(){
        return this.name;
    }
    public int getLevel(){
        return this.level;
    }
    public int getPrice(){
        return this.price;
    }
    public int getPointsIncrease(){
        return this.pointsIncrease;
    }
    
}