package Game;

import Creatures.Air;
import Creatures.Earth;
import Creatures.Fire;
import Creatures.Water;
import Creatures.Creature;
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
        int x = 0;


        for (int i = 0; i < map.length; i++) {
            Creature iwanttodie = new Creature();
            iwanttodie.Fill();

            for (int j = 0; j < map[i].length; j++) {
                int roomtype = (int) Math.floor(Math.random() * 3);
                int monstertype = (int) Math.floor(Math.random() * 5);
               // System.out.print(monstertype);
                //System.out.println(roomtype);

                if (roomtype == 0) {

                    if (monstertype < 3) {
                        Fire iwanttodie2 = new Fire(iwanttodie);
                        iwanttodie2.apply();
                        map[i][j] = new House(i, j, iwanttodie2);
                        System.out.print(iwanttodie2.getAttack() + " ");

                    }
                    else
                    {
                        Water iwanttodie2 = new Water(iwanttodie);
                        iwanttodie2.apply();
                        System.out.print(iwanttodie2.getAttack() + " ");
                        map[i][j] = new House(i, j, iwanttodie2);


                    }

                }

                if (roomtype == 1) {

                    if (monstertype < 3)
                    {
                        Earth iwanttodie2 = new Earth(iwanttodie);
                        iwanttodie2.apply();
                        map[i][j] = new House(i, j, iwanttodie2);

                        System.out.print(iwanttodie2.getAttack() + " ");


                    }
                    else  {
                        Water iwanttodie2 = new Water(iwanttodie);
                        iwanttodie2.apply();
                        map[i][j] = new House(i, j, iwanttodie2);

                        System.out.print(iwanttodie2.getAttack() + " ");


                    }

                }

                if (roomtype == 2) {

                    if (monstertype < 3)
                    {
                        Air iwanttodie2 = new Air(iwanttodie);
                        iwanttodie2.apply();
                        map[i][j] = new House(i, j, iwanttodie2);
                        System.out.print(iwanttodie2.getAttack() + " ");

                    }
                    else
                    {
                        Fire iwanttodie2 = new Fire(iwanttodie);
                        iwanttodie2.apply();
                        map[i][j] = new House(i, j, iwanttodie2);
                        System.out.print(iwanttodie2.getAttack() + " ");
                    }
                }

              //  System.out.print(iwanttodie.getAttack());
            }
            System.out.println();

        }


    }





/*


       int num = (int) Math.floor(Math.random() * 5);
       if (num == 0)
       {
           Air one = new Air();
           one.Fill();
           one.apply();
       }

        if (num == 1)
        {
            Earth one = new Earth();
            one.Fill();
            one.apply();
        }
        if (num == 0)
        {
            Fire one = new Fire();
            one.Fill();
            one.apply();
        }
        if (num == 0)
        {
            Water one = new Water();
            one.Fill();
            one.apply();
        }



    }

*/


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
