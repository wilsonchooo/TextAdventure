package Rooms;

import Creatures.Creature;
import People.Person;

import java.util.Scanner;

import static People.Person.bag;

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

    public void captureCreature(Person person)
    {
        for (int i=0;i<person.getBag().length;i++)
        {
            if (person.getBag()[i].getName().equals("") )
            {
                person.getBag()[i] = this.creature;
                break;
            }

        }
		if (!person.getBag()[5].getName().equals(""))
		{
			System.out.println("What is the position of the pokemon you want to replace");
			Scanner replace = new Scanner(System.in);
			String stringnumber = replace.nextLine();
			int number = Integer.parseInt(stringnumber);
			replaceCreature(person,number);
		}

    }
    public void replaceCreature(Person person, int position )
	{
		person.getBag()[position].name = this.creature.name;
		person.getBag()[position].attack = this.creature.attack;
		person.getBag()[position].defense = this.creature.defense;
		person.getBag()[position].speed = this.creature.speed;
		person.getBag()[position].weight = this.creature.weight;

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
