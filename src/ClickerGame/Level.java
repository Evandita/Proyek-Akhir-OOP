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
            case BEGGAR :
                return 0;
            case COMMONER :
                return 1;
            case MERCHANT:
                return 2;
            case NOBLE:
                return 3;
            case KING:
                return 4;
            case EMPEROR:
                return 5;
            default:
                return -1;
        }
    }
}