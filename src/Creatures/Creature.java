package Creatures;
import java.util.Arrays;

public class Creature {
    public double weight;
    public String name;
    public double attack;

    public double speed;
    public double defense;
    int  xLoc, yLoc;

    public Creature()
    {
    }

    public Creature(String name, double weight,  double attack, double speed, double defense)
        {
            this.weight = weight;
            this.name = name;
            this.attack = attack;
            this.speed=speed;
            this.defense=defense;

        }

        public void Fill()
        {
            double [] stats = new double[4];

            for (int i = 0; i< stats.length;i++)
            {

                stats[i] =  (int) ((Math.random() * 90) + 10) / 10.0;


            }
            this.name = "zz";
            this.weight = stats[0];
            this.attack = stats[1];
            this.speed = stats[2];
            this.defense = stats[3];

           // System.out.println(Arrays.toString(stats));



        }


    public static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }


        public double getAttack()
    {
        return attack;
    }
    public String getName()
    {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public double getSpeed() {
        return speed;
    }
    public double getDefense() {
        return defense;
    }




    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }


}
