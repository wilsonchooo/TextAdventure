package Creatures;


public class Air extends Creature {

    public Air()
    {

    }

    public Air (Creature creature)
    {
        this.weight = creature.weight;
        this.attack = creature.attack;
        this.speed = creature.speed;
        this.defense = creature.defense;

    }
    public Air (double weight, String name, double attack, double speed, double defense )
    {
        super(name,weight,attack,speed,defense);
    }

    public void apply()
    {
        this.weight = round(this.weight *.5,2);

        this.attack =round(this.attack *.9,2);

        this.speed = round(this.speed *2,2) ;

        this.defense =round(this.defense *.8,2);

    }




}
