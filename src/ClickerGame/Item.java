package ClickerGame;

//Type Item
public class Item{
    public enum Rarity {
        COMMON(5),
        UNCOMMON(20),
        RARE(50),
        EPIC(100),
        LEGENDARY(2000);

        private int rate;

        private Rarity(int rate) {
            this.rate = rate;
        }

        public int getRate() {
            return rate;
        }
    }
    public String name;
    public int level;
    public Rarity rarity;
    public double earningIncrease;

    //Constructor
    public Item(String name, Rarity rarity, double earningIncrease){
        this.name = name;
        this.level = 1;
        this.rarity = rarity;
        this.earningIncrease = earningIncrease;
    }

    //Setter
    public void setName(){
        this.name = name;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setRarity(Rarity rarity){
        this.rarity = rarity;
    }
    public void setEarningIncrease(double earningIncrease){
        this.earningIncrease = earningIncrease;
    }
    //Getter
    public String getName(){
        return this.name;
    }
    public int getLevel(){
        return this.level;
    }
    public Rarity getRarity(){
        return this.rarity;
    }
    public double getEarningIncrease(){
        return this.earningIncrease;
    }

    //Method
    private void upgrade(){
        this.level ++;
        this.earningIncrease += rarity.getRate();
        }//belum tambah rumus

     public static void main(String[] args) {
        Item commonItem = new Item("Social Media Influence Bot", Rarity.COMMON, 1000);
        Item rareItem = new Item("Mindfulness Meditation App", Rarity.LEGENDARY, 5000);

        

        System.out.println("Common Item Increased Value: " + commonItem.earningIncrease);
        System.out.println("Rare Item Increased Value: " + rareItem.earningIncrease);

        commonItem.upgrade();
        rareItem.upgrade();

        
        System.out.println("Common Item Increased Value: " + commonItem.earningIncrease);
        System.out.println("Rare Item Increased Value: " + rareItem.earningIncrease);
    }
}