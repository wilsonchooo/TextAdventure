package Creatures;


public class Fire extends Creature {
    public Fire()
    {

    }

    public Fire (Creature creature)
    {
        this.weight = creature.weight;
        this.attack = creature.attack;
        this.speed = creature.speed;
        this.defense = creature.defense;
    }

    public Fire (double weight, String name, double attack, double speed, double defense  )
    {
        super(name, weight,attack,speed,defense);
    }




    public void apply()
    {
        this.weight =round(this.weight *1.3,2);

        this.attack =round(this.attack*3,2);

        this.speed = round(this.speed *1.1,2) ;

        this.defense = round(this.defense *.7,2);

    }

}