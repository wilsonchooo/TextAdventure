package Creatures;


public class Earth extends Creature {

    public Earth (int weight, String name, int speed, int defense, int xLoc, int yLoc )
    {
        super(weight,name,speed,defense, xLoc, yLoc);
    }


    public static double speed (int speed)
    {
        double speed2 =  speed *.78;
        return speed2;
    }

    public static double defense (int defense)
    {
        double defense2 =  defense *1.6;
        return defense2;
    }
}
