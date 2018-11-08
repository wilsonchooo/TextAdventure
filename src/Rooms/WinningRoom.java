package Rooms;

import Creatures.Creature;
import Game.Runner;
import People.Person;

public class WinningRoom extends Room
{

	public WinningRoom(int x, int y) {
		super(x, y);

	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("That's the end of your journey.");
		Runner.gameOff();
	}
	

}
