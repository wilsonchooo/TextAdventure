package Creatures;


public class Water extends Creature {
    public Water()
    {

    }

    public Water (Creature creature)
    {
        this.name = creature.name;
        this.weight = creature.weight;
        this.attack = creature.attack;
        this.speed = creature.speed;
        this.defense = creature.defense;
    }

    public Water (double weight, String name, double attack, double speed, double defense  )
    {
        super(name, weight,attack,speed,defense);
    }


    public void apply()
    {
        this.weight = round(this.weight *.8,2);

        this.attack =round(this.attack*3,2) ;

        this.speed =round(this.speed *1.5,2);

        this.defense =round(this.defense *.8,2);

    }
}