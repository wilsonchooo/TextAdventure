package Rooms;

import Creatures.Air;
import Creatures.Creature;
import People.Person;

public class Forest extends Room {


    public Forest(int x, int y, Creature z) {
        super(x, y, z);
    }

    public void change()
    {
        Air yes = new Air (this.creature);
    }

    public void enterRoom(Person x)
    {
        System.out.println("You enter a forest.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
}

