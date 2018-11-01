package Creatures;

public class Creature {
    private int weight;
    private String name;
    private int speed;
    private int defense;
    int xLoc, yLoc;

    public Creature(int weight, String name, int speed, int defense, int xLoc, int yLoc)
        {
            this.weight = weight;
            this.name = name;
            this.speed=speed;
            this.defense=defense;
            this.xLoc = xLoc;
            this.yLoc = yLoc;
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
