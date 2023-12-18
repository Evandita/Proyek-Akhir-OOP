package ClickerGame;

public enum Level { //ENUMERATION untuk level
    //format
    BEGGAR,
    COMMONER,
    MERCHANT,
    NOBLE,
    KING,
    EMPEROR;

    // cast int to enum
    public static Level fromInt(int level) {
        switch (level) {
            case 0 : 
                return BEGGAR;
            case 1 :
                return COMMONER;
            case 2 :
                return MERCHANT;
            case 3 :
                return NOBLE;
            case 4 :
                return KING;
            case 5 :
                return EMPEROR;
            default :
                return null;
        }
    }

    // cast enum to int
    public static int toInt(Level renown) {
        switch (renown) {
            case ENUM0 :
                return 0;
            case ENUM1 :
                return 1;
            default:
                return -1;
        }
    }
}