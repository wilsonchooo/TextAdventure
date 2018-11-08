package People;

import Creatures.Creature;

import java.util.Scanner;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
	String firstName;
	String familyName;
	int xLoc, yLoc;
	public static Creature[] bag = new Creature[6];





	 public Creature[] getBag()
	 {
	 	return bag;
	 }


public void getstats(Person x)
{
	Scanner statposition = new Scanner(System.in);

	int position = statposition.nextInt() ;
	System.out.println("This pokemon's name is " +x.getBag()[position+-1].name);
	System.out.println("Attack: " +x.getBag()[position-1].attack);
	System.out.println("Speed: " +x.getBag()[position-1].speed);
	System.out.println("Defense: " +x.getBag()[position-1].defense);
	System.out.println("Weight: " +x.getBag()[position-1].weight);
}

	 public void printbag ()
	 {
	 	for (int i=0; i< this.bag.length;i++)
		{
			if (this.bag[i].getName().equals(""))
				System.out.println("blank");
			else {

				System.out.println( this.bag[i].getName());
			}
		}
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

	public Person (String firstName, String familyName, int xLoc, int yLoc)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}


}
