package Rooms;

import Creatures.Creature;
import People.Person;

public class Road extends Room {


    public Road(int x, int y, Creature z) {
        super(x, y, z);
    }
    public void enterRoom(Person x)
    {
        System.out.println("You enter a Road.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
}

