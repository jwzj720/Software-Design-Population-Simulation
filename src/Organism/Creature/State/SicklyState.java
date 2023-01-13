package Organism.Creature.State;

import Organism.Creature.Creature;

public class SicklyState implements State{
    private Creature creature;
    /**
    When a creature is not healthy it cannot reproduce
    @param Creature creature that is sickly
     */
    public SicklyState(Creature creature){
        this.creature = creature;
        this.creature.setCanReproduce(false);
    }

    /**
    Sets a creatures state to Sickly if it has health below 50
     */
    @Override
    public void doAction() {
        double creatureHealth = this.creature.getHealth();
        if(creatureHealth>=50){
            this.creature.setCurrentState(new HealthyState(this.creature));
            
        }else if(creatureHealth<=0){
            this.creature.setCurrentState(new DeadState(this.creature));
        }  
    };

}