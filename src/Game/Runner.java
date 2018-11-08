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



		//Create a random winning room.
		String[][] visual = new String[5][5];

		Board board = new Board(5,5);
		board.fillBoard(visual);

		Creature z = new Creature();
		board.map[4][4] = new WinningRoom(4, 4);



		 Creature[] bag = new Creature[6];

		Person player1 = new Person("FirstName", "FamilyName", 0,0);


		board.playerbag(player1);

		board.enter(player1);
		visual[player1.getxLoc()][player1.getyLoc()] = "*";

		board.printboard(visual);
		player1.printbag();

		System.out.println("Write stats or stat to find out the stats on your pokemon");


		//building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W)");

			String move = in.nextLine();

			if(validMove(move, player1, board.map,visual))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				//visual[player1.getxLoc()][player1.getyLoc()] = "((" + visual[player1.getxLoc()][player1.getyLoc()] +" ))";
				System.out.println("you encounter a " + board.getCreature(player1).getName());
				System.out.println("Would you like to catch it?");
				String catchthing = in.nextLine();
				if (catchthing.equals("catch") || catchthing.equals("yes") || catchthing.equals("Yes") ||catchthing.equals("ok") || catchthing.equals("capture")||catchthing.equals("y"))
					{
						board.capture(player1);
						player1.printbag();


						//board.map[player1.getxLoc()][player1.getyLoc()].getCreature().name = "";


					}
				visual[player1.getxLoc()][player1.getyLoc()] = "*";

					board.printboard(visual);
			}
			else
				{
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
	public static boolean validMove(String move, Person p, Room[][] map, String [][] visual)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "stat":
			{
					p.getstats(p);
					break;
			}

			case "stats":
			{
					p.getstats(p);
					break;
				}



			case "n":
				if (p.getxLoc() > 0)
				{
				    if (!visual[p.getxLoc()-1][p.getyLoc()].equals("*") ) {
                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
                        return true;
                    }
                    else return false;

				}
				else
				{
					return false;
				}
			case "e":
				if (p.getyLoc()< map[p.getyLoc()].length -1  )
				{
                    if (!visual[p.getxLoc()][p.getyLoc()+1].equals("*") ) {
                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                        return true;
                    }
                    else return false;

                }
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1 )
				{
                    if (!visual[p.getxLoc()+1][p.getyLoc()].equals("*") ) {

                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
                        return true;
                    }
                    else return false;

                }
				else
				{
					return false;
				}

			case "w":
				if (p.getyLoc() > 0 )
				{
                    if (!visual[p.getxLoc()][p.getyLoc()-1].equals("*") ) {

                        map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        map[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
                        return true;
                    }
                    else return false;

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
