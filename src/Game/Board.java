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

    public void fillBoard() {

        String[] names = {"name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9", "name10", "name11", "name12", "name13", "name14", "name15", "name16", "name17", "name18", "name19", "name20", "name21", "name22", "name23", "name24", "name25",};

        Air one = new Air();
        one.Fill();
        one.apply();


        for (int i = 0; i < map.length; i++) {
            Creature creature = new Creature();
            creature.Fill();

            for (int j = 0; j < map[i].length; j++) {
                int roomtype = (int) Math.floor(Math.random() * 3);
                int monstertype = (int) Math.floor(Math.random() * 5);
               // System.out.print(monstertype);
                //System.out.println(roomtype);

                if (roomtype == 0) {

                    if (monstertype < 3) {
                        Fire creature2 = new Fire(creature);
                        creature2.apply();
                        map[i][j] = new House(i, j, creature2);
                     //   System.out.print(iwanttodie2.getAttack() + " ");
                    }
                    else
                    {
                        Water creature2 = new Water(creature);
                        creature2.apply();
                        //System.out.print(iwanttodie2.getAttack() + " ");
                        map[i][j] = new House(i, j, creature2);
                    }
                    System.out.print("H  ");
                }
                if (roomtype == 1) {

                    if (monstertype < 3)
                    {
                        Earth creature2 = new Earth(creature);
                        creature2.apply();
                        map[i][j] = new Forest(i, j, creature2);
                       // System.out.print(iwanttodie2.getAttack() + " ");
                    }
                    else
                        {
                        Water creature2 = new Water(creature);
                            creature2.apply();
                        map[i][j] = new Forest(i, j, creature2);
                        //System.out.print(iwanttodie2.getAttack() + " ");
                    }
                    System.out.print("F  ");
                }
                if (roomtype == 2) {

                    if (monstertype < 3)
                    {
                        Air creature2 = new Air(creature);
                        creature2.apply();
                        map[i][j] = new Road(i, j, creature2);
                     //   System.out.print(iwanttodie2.getAttack() + " ");
                    }
                    else
                    {
                        Fire creature2 = new Fire(creature);
                        creature2.apply();
                        map[i][j] = new Road(i, j, creature2);
                      //  System.out.print(iwanttodie2.getAttack() + " ");
                    }
                    System.out.print("R  ");
                }
              //  System.out.print(iwanttodie.getAttack());
            }
            System.out.println();
        }


    }


    public void playerbag(Person x)
    {
        x.bag[0] = new Creature("",0,0,0,0);
        x.bag[1] = new Creature("pp",0,0,0,0);
        x.bag[2] = new Creature("",0,0,0,0);
        x.bag[3] = new Creature("",0,0,0,0);
        x.bag[4] = new Creature("",0,0,0,0);
        x.bag[5] = new Creature("",0,0,0,0);

    }
public void enter(Person x)
{

    map[x.getxLoc()][x.getyLoc()].enterRoom(x);
    map[x.getxLoc()][x.getyLoc()].captureCreature(x);

   // x.bag[0] = map[0][0].getCreature();



   // System.out.println(x.bag[0].getAttack());
    x.printbag();
   // map[0][0].captureCreature(x.getBag());
}

public void capture(Person x)
{
    map[x.getxLoc()][x.getyLoc()].captureCreature(x);

}

public Creature getCreature(Person x)
{
    return map[x.getxLoc()][x.getyLoc()].creature;

}







    public void printBoard()
    {
        for (Room[] i:map)
        {
            for (Room j:i)
            {
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
