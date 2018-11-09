package Creatures;


public class Earth extends Creature {
    public Earth() //Empty Constructor
    {

    }

    public Earth (Creature creature) // Takes in a creature in order to build an "Earth" creature with the same attributes.
    {
        this.name = creature.name;

        this.weight = creature.weight;
        this.attack = creature.attack;
        this.speed = creature.speed;
        this.defense = creature.defense;
    }

    public Earth (double weight, String name, double attack, double speed, double defense ) // Takes creature stats from a normal creature
    {
        super(name, weight,attack,speed,defense);
    }



        public void apply() // Changes the stats to fit with earth
        {
            this.weight = round(this.weight *8,2);

            this.attack =round(this.attack*1.3,2);

            this.speed = round(this.speed *.62,2) ;

            this.defense = round(this.defense *1.6,2);

        }
    public String getType() //returns type
    {
        String Type = "Earth";
        return Type;
    }

}
