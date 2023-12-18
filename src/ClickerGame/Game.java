package ClickerGame;

public class Game
{
    private String name;    // player name
    private double credit;  // total social credit
    private double earnings;    // credit earnings per click
    private Level renown;   // player social standings (level)
    
    private static Game instance; //singleton
    
    private Game() { //private constructor
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
    

    //getter
    public String getName() {
        return name;
    }
    
    public double getcredit() {
        return credit;
    }
    
    public double getEarnings() {
        return earnings;
    }

    public int getRenown() { // return renown level
        return Level.toInt(renown);
    }

    public Level getRenownName() { // return renown name
        return renown;
    }
}
