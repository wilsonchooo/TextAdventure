package Rooms;

import Creatures.Creature;
import People.Person;

public class Room {
	Person occupant;
	int xLoc,yLoc;
	public Creature creature;

	public Room()
    {

    }
	public Room(int x, int y, Creature z)
	{
		xLoc = x;
		yLoc = y;
		this.creature = z;
	}

	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */

	public Creature getCreature()
    {
        return this.creature;
    }
	public void enterRoom(Person x)
	{
		System.out.println("You enter a plain old room");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
	
}
