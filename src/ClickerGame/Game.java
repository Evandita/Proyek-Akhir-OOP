package ClickerGame;

import java.util.List;

public class Game extends savedObjects
{
    private String name;    // player name
    private double credit;  // total social credit
    private double earnings;    // credit earnings per click
    private double earningMultiplier;
    private Level renown;   // player social standings (level)
    
    private static Game instance; //singleton
    
    private Game() { //private constructor
        setName("Bezos");
        setcredit(0);
        setEarnings(1);
        setEarningMultiplier(1);
        setRenown(0);
    }
    
    public static synchronized Game getInstance() { //get instance
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    
    //setter
    public void setName(String name) {
        this.name = name;
    }
    
    public void setcredit(double credit) {
        this.credit = credit;
    }
    
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public void setRenown(int level) {
        this.renown = Level.fromInt(level);
    }

    public void setEarningMultiplier(double earningMultiplier) {
        this.earningMultiplier = earningMultiplier;
    }
    

    //getter
    public String getName() {
        return instance.name;
    }
    
    public double getcredit() {
        return instance.credit;
    }
    
    public double getEarnings() {
        return instance.earnings;
    }

    public int getRenown() { // return renown level
        return Level.toInt(instance.renown);
    }

    public Level getRenownName() { // return renown name
        return instance.renown;
    }

    public double getEarningMultiplier() {
        return instance.earningMultiplier;
    }


    //to string
    @Override
    public String toString() {
        return  "" + this.name + "\n"
                + this.credit + "\n"
                + this.earnings + "\n"
                + this.earningMultiplier + "\n"
                + Level.toInt(this.renown);
    }

    //from string
    public void fromString(List<String> datas) {
        instance.setName(datas.get(0));
        instance.setcredit(Double.parseDouble(datas.get(1)));
        instance.setEarnings(Double.parseDouble(datas.get(2)));
        instance.setEarningMultiplier(Double.parseDouble(datas.get(3)));
        instance.setRenown(Integer.parseInt(datas.get(4)));
    }
}
