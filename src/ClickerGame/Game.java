package ClickerGame;

import java.util.List;

public class Game extends savedObjects
{   

    //Game Data

    private int points;  
    private int pointsPerClick;
    private int pointsPerClickMultiplier;
    private int cummulativePoints;
    private int totalClicks;
    private int totalItems;
    private Level renown;   // player social standings (level)
    public List<Item> shopItems;
    
    private static Game instance; //singleton
    
    private Game() { //private constructor
        setPoints(0);
        setPointsPerClick(1);
        setPointsPerClickMultiplier(1);
        setCummulativePoints(0);
        setTotalClicks(0);
        setTotalItems(0);
        setRenown(0);
        this.shopItems = new Shop().items;
    }
    
    public static synchronized Game getInstance() { //get instance
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    
    //setter
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public void setPointsPerClick(int pointsPerClick) {
        this.pointsPerClick = pointsPerClick;
    }

    public void setRenown(int level) {
        this.renown = Level.fromInt(level);
    }

    public void setPointsPerClickMultiplier(int pointsPerClickMultiplier) {
        this.pointsPerClickMultiplier = pointsPerClickMultiplier;
    }

    public void setTotalClicks(int totalClicks) {
        this.totalClicks = totalClicks;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public void setCummulativePoints(int cummulativePoints) {
        this.cummulativePoints = cummulativePoints;
    }
    

    //getter
    
    public int getPoints() {
        return instance.points;
    }
    
    public int getPointsPerClick() {
        return instance.pointsPerClick;
    }

    public int getRenown() { // return renown level
        return Level.toInt(instance.renown);
    }

    public Level getRenownName() { // return renown name
        return instance.renown;
    }

    public int getPointsPerClickMultiplier() {
        return instance.pointsPerClickMultiplier;
    }

    public int getTotalClicks() {
        return instance.totalClicks;
    }

    public int getTotalItems() {
        return instance.totalItems;
    }

    public int getCummulativePoints() {
        return cummulativePoints;
    }


    //to string
    @Override
    public String toString() {
        return  "" + this.points + "\n"
                + this.pointsPerClick + "\n"
                + this.pointsPerClickMultiplier + "\n"
                + this.cummulativePoints + "\n"
                + this.totalClicks + "\n"
                + this.totalItems + "\n"
                + Level.toInt(this.renown);
    }

    //from string
    public void fromString(List<String> datas) {
        instance.setPoints(Integer.parseInt(datas.get(0)));
        instance.setPointsPerClick(Integer.parseInt(datas.get(1)));
        instance.setPointsPerClickMultiplier(Integer.parseInt(datas.get(2)));
        instance.setCummulativePoints(Integer.parseInt(datas.get(3)));
        instance.setTotalClicks(Integer.parseInt(datas.get(4)));
        instance.setTotalItems(Integer.parseInt(datas.get(5)));
        instance.setRenown(Integer.parseInt(datas.get(6)));
    }
}
