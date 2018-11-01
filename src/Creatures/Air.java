package Creatures;


public class Air extends Creature {

    public Air (int weight, String name, int speed, int defense , int xLoc, int yLoc )
    {
        super(weight,name,speed,defense, xLoc, yLoc);
    }

    public static double speed (int speed)
    {
       double speed2 =  speed *1.5;
       return speed2;
    }

    public static double defense (int defense)
    {
        double defense2 =  defense *.8;
        return defense2;
    }



}
