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



		//Create a random winning room.
		String[][] visual = new String[5][5];

		Board board = new Board(5,5);
		board.fillBoard(visual);

		board.map[4][4] = new WinningRoom(4, 4); //Creates a winning room at [4][4]



		 Creature[] bag = new Creature[6];

		Person player1 = new Person("FirstName", "FamilyName", 0,0);


		board.playerbag(player1);

		board.enter(player1);
		visual[player1.getxLoc()][player1.getyLoc()] = "*"; //Shows the players current location

		board.printBoard(visual);
		player1.printbag();



		//building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W) Stats or Guide");

			String move = in.nextLine();

			if(validMove(move, player1, board.map,visual))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                visual[0][0] = "x";
				visual[player1.getxLoc()][player1.getyLoc()] = "*";
				//visual[player1.getxLoc()][player1.getyLoc()] = "((" + visual[player1.getxLoc()][player1.getyLoc()] +" ))";
				System.out.println("you encounter a " + board.getCreature(player1).getName());
				System.out.println("Would you like to catch it?");
				String catchthing = in.nextLine();
				if (catchthing.equals("catch") || catchthing.equals("yes") || catchthing.equals("Yes") ||catchthing.equals("ok") || catchthing.equals("capture")||catchthing.equals("y"))
					{
                        int catchrandom = (int) Math.floor(Math.random() * 11);

                        for (int i=0;i<3;i++) {
                            try {
                                Thread.sleep(500);
                                System.out.println(".");
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        if (catchrandom <= 5)
                        {
                            board.capture(player1);
                            player1.printbag();
                        }
                        else
                        {
                            System.out.println("It ran away..");
                        }
					}
                board.printBoard(visual);

                visual[player1.getxLoc()][player1.getyLoc()] = "x";

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
			case "stat": //if user inputs stats or stat gives them the stats of the position that they specify
			{
			        p.printbag();
					p.getstats(p);
					return false;
			}

			case "stats":
			{
                p.printbag();
                p.getstats(p);
				return false;
				}




            case "guide":
            {
                System.out.println("There are three types of terrain in this game: ");
                System.out.println("House: only fire and water type pokemon can be found here.");
                System.out.println("Road: only air and fire type pokemon can be found here.");
                System.out.println("Forest: only earth and water type pokemon can be found here. ");
                System.out.println();
                System.out.println("Air pokemon have an attack multiplier of .9, speed multiplier of 2, defense multiplier of .8 and a weight multiplier of .5.");
                System.out.println("Earth pokemon have an attack multiplier of 1.3, speed multiplier of .62, defense multiplier of 1.6 and a weight multiplier of 8.");
                System.out.println("Fire pokemon have an attack multiplier of 3, speed multiplier of 1.1, defense multiplier of .7 and a weight multiplier of 1.3.");
                System.out.println("Water pokemon have an attack multiplier of 3, speed multiplier of 1.5, defense multiplier of .8 and a weight multiplier of .8.");
                System.out.println();

                return false;




            }
			case "n":
				if (p.getxLoc() > 0)
				{
				    if (!visual[p.getxLoc()-1][p.getyLoc()].equals("x") ) {
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
                    if (!visual[p.getxLoc()][p.getyLoc()+1].equals("x") ) {
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
                    if (!visual[p.getxLoc()+1][p.getyLoc()].equals("x") ) {

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
                    if (!visual[p.getxLoc()][p.getyLoc()-1].equals("x") ) {

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
