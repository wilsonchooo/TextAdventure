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


    public void fillBoard(String [][] visual) {


        for (int i = 0; i < map.length; i++) {
            Creature creature = new Creature();
            creature.Fill();

            for (int j = 0; j < map[i].length; j++) {
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
                   // System.out.print("H  ");
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
                 //   System.out.print("F  ");
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
                   // System.out.print("R  ");
                    visual[i][j] = "R";
                }
            }
            //System.out.println();
        }


    }


    public void playerbag(Person x)
    {
        x.bag[0] = new Creature("",0,0,0,0);
        x.bag[1] = new Creature("",0,0,0,0);
        x.bag[2] = new Creature("",0,0,0,0);
        x.bag[3] = new Creature("",0,0,0,0);
        x.bag[4] = new Creature("",0,0,0,0);
        x.bag[5] = new Creature("",0,0,0,0);

    }
public void enter(Person x)
{

    map[x.getxLoc()][x.getyLoc()].enterRoom(x);
    map[x.getxLoc()][x.getyLoc()].captureCreature(x);


}

public void capture(Person x)
{
    map[x.getxLoc()][x.getyLoc()].captureCreature(x);

}

public Creature getCreature(Person x)
{
    return map[x.getxLoc()][x.getyLoc()].creature;

}



   public void printboard (String[][]x) {
        for (int i = 0; i < x.length; i++)
        {

            System.out.print(Arrays.toString(x[i]));
            System.out.println();

        }

   }

}
