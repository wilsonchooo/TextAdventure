package Creatures;


public class Fire extends Creature {
    public Fire() //Empty Constructor
    {

    }

    public Fire (Creature creature) // Takes in a creature in order to build an "Air" creature with the same attributes.
    {
        this.name = creature.name;

        this.weight = creature.weight;
        this.attack = creature.attack;
        this.speed = creature.speed;
        this.defense = creature.defense;
    }

    public Fire (double weight, String name, double attack, double speed, double defense  ) // Takes creature stats from a normal creature
    {
        super(name, weight,attack,speed,defense);
    }




    public void apply() // Changes the stats to fit with fire
    {
        this.weight =round(this.weight *1.3,2);

        this.attack =round(this.attack*3,2);

        this.speed = round(this.speed *1.1,2) ;

        this.defense = round(this.defense *.7,2);

    }
    public String getType() //returns type
    {
        String Type = "Water";
        return Type;
    }

}