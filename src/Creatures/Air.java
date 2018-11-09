package Creatures;


public class Air extends Creature {

    public Air() //Empty Constructor
    {

    }

    public Air (Creature creature) // Takes in a creature in order to build an "Air" creature with the same attributes.
    {
        this.name = creature.name;
        this.weight = creature.weight;
        this.attack = creature.attack;
        this.speed = creature.speed;
        this.defense = creature.defense;
    }

    public Air (double weight, String name, double attack, double speed, double defense ) // Takes creature stats from a normal creature
    {
        super(name,weight,attack,speed,defense);
    }

    public void apply() // Changes the stats to fit with air
    {
        this.weight = round(this.weight *.5,2);

        this.attack =round(this.attack *.9,2);

        this.speed = round(this.speed *2,2) ;

        this.defense =round(this.defense *.8,2);


    }
    public String getType() //returns type
    {
        String Type = "Air";
        return Type;
    }




}
