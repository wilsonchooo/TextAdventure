package Game;

import Creatures.Air;
import Creatures.Earth;
import Creatures.Fire;
import Creatures.Water;
import Creatures.Creature;
import People.Person;
import Rooms.Forest;
import Rooms.House;
import Rooms.Road;
import Rooms.Room;

import java.util.Arrays;

public class Board {
    Room[][] map;

    public Board(Room[][] map) {
        this.map = map;
    }

    public Board(int height, int width) {
        map = new Room[height][width];
    }

    public void addRoom(Room room, int row, int col) {
        map[row][col] = room;
    }


    public void fillBoard(String [][] visual) { //Fills the board with randomly made creatures. Also randomly creates different rooms and makes creatures according to the room type.


        for (int i = 0; i < map.length; i++) {


            for (int j = 0; j < map[i].length; j++) {
                Creature creature = new Creature();
                creature.Fill();
                int roomtype = (int) Math.floor(Math.random() * 3);
                int monstertype = (int) Math.floor(Math.random() * 5);

                if (roomtype == 0) {

                    if (monstertype < 3) {
                        Fire creature2 = new Fire(creature);
                        creature2.apply();
                        map[i][j] = new House(i, j, creature2);
                    }
                    else
                    {
                        Water creature2 = new Water(creature);
                        creature2.apply();
                        map[i][j] = new House(i, j, creature2);
                    }
                    visual[i][j] = "H";
                }
                if (roomtype == 1) {

                    if (monstertype < 3)
                    {
                        Earth creature2 = new Earth(creature);
                        creature2.apply();
                        map[i][j] = new Forest(i, j, creature2);
                    }
                    else
                        {
                        Water creature2 = new Water(creature);
                            creature2.apply();
                        map[i][j] = new Forest(i, j, creature2);
                    }
                    visual[i][j] = "F";
                }
                if (roomtype == 2) {

                    if (monstertype < 3)
                    {
                        Air creature2 = new Air(creature);
                        creature2.apply();
                        map[i][j] = new Road(i, j, creature2);
                    }
                    else
                    {
                        Fire creature2 = new Fire(creature);
                        creature2.apply();
                        map[i][j] = new Road(i, j, creature2);
                    }
                    visual[i][j] = "R";
                }
            }
        }


    }



    public void playerbag(Person x) //creates an empty bag
    {
        x.bag[0] = new Creature("",0,0,0,0);
        x.bag[1] = new Creature("",0,0,0,0);
        x.bag[2] = new Creature("",0,0,0,0);
        x.bag[3] = new Creature("",0,0,0,0);
        x.bag[4] = new Creature("",0,0,0,0);
        x.bag[5] = new Creature("",0,0,0,0);

    }
public void enter(Person x) //Allows the player to catch a creature
{

    map[x.getxLoc()][x.getyLoc()].enterRoom(x);
    map[x.getxLoc()][x.getyLoc()].captureCreature(x);


}

public void capture(Person x) //Allows player to capture creature
{
    map[x.getxLoc()][x.getyLoc()].captureCreature(x);

}

public Creature getCreature(Person x) //Gets a creature from a room
{
    return map[x.getxLoc()][x.getyLoc()].creature;

}




   public void printBoard(String [][] x) //prints the board
   {
       for (String[] i : x)
       {
           for (String j : i)
           {
               System.out.print(j + "  ");

           }
           System.out.println();
       }
   }

}
