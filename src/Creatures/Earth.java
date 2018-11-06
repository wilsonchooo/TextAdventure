package Creatures;


public class Earth extends Creature {
    public Earth()
    {

    }

    public Earth (Creature creature)
    {
        this.name = creature.name;

        this.weight = creature.weight;
        this.attack = creature.attack;
        this.speed = creature.speed;
        this.defense = creature.defense;
    }

    public Earth (double weight, String name, double attack, double speed, double defense )
    {
        super(name, weight,attack,speed,defense);
    }



        public void apply()
        {
            this.weight = round(this.weight *8,2);

            this.attack =round(this.attack*1.2,2);

            this.speed = round(this.speed *.62,2) ;

            this.defense = round(this.defense *1.6,2);

        }

}
