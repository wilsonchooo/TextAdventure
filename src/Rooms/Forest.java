package Rooms;

import Creatures.Air;
import Creatures.Creature;

public class Forest extends Room {


    public Forest(int x, int y, Creature z) {
        super(x, y, z);
    }

    public void change()
    {
        Air yes = new Air (this.creature);
    }
}

