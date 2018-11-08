package Rooms;

import Creatures.Creature;
import People.Person;

public class House extends Room{


    public House(int x, int y, Creature z)
    {
        super(x,y,z);
    }

    public void enterRoom(Person x)
    {
        System.out.println("You enter a House.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

}
