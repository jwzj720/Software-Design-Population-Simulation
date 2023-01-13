package Organism.Creature.State;

import Organism.Creature.Creature;

public class HealthyState implements State{
    private Creature creature;
    /**
    defines the healthy state for a creature which allows reproduction
    @param Creature that is healthy
     */
	public HealthyState(Creature creature){
		this.creature = creature;
        this.creature.setCanReproduce(true);
	}
    /**
    Sets the state of the creature based on health levels */
    @Override
    public void doAction() {
        double creatureHealth = creature.getHealth();
        if(creatureHealth <= 50.0 && creatureHealth > 0){
            this.creature.setCurrentState(new SicklyState(creature)); 
        }else if(creatureHealth<=0){
            this.creature.setCurrentState(new DeadState(this.creature));
        } 
    };
    
}