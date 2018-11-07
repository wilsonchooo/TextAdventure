package Game;

import Creatures.Air;
import Creatures.Creature;
import People.Person;
import Rooms.Room;
import Rooms.WinningRoom;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Room[][] building = new Room[5][5];
		
		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			Creature z = null;
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y,z);
			}

		}

		Board board = new Board(5,5);
		board.fillBoard();

		//board.printBoard();


		Creature z = new Creature();

		//z.Fill();

		/*
		System.out.println(z.getWeight());
		System.out.println(z.getAttack());
		System.out.println(z.getSpeed());

		System.out.println(z.getDefense());




		Air test = new Air();
		test.Fill();
		test.apply();

		System.out.println(test.getWeight());
		System.out.println(test.getAttack());
		System.out.println(test.getSpeed());
		System.out.println(test.getDefense());
*/

		//Create a random winning room.

		board.map[4][4] = new WinningRoom(4, 4,z);



		 Creature[] bag = new Creature[6];

		 //Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0,0);


		board.playerbag(player1);

		board.enter(player1);



		//building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();

			if(validMove(move, player1, board.map))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				System.out.println("you encounter a " + board.getCreature(player1).getName());
				System.out.println("Would you like to catch it?");
				String catchthing = in.nextLine();
				if (catchthing.equals("catch") || catchthing.equals("yes") || catchthing.equals("ok") || catchthing.equals("capture"))

					{
						board.capture(player1);

						player1.printbag();
					}


			}
			else {
				System.out.println("Please choose a valid move.");
			}
			
			
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);

					return true;
				}
				else
				{
					return false;
				}
			case "e":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "w":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}


				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
	


}
