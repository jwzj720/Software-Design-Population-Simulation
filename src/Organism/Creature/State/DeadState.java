package Organism.Creature.State;

import Organism.Creature.Creature;
import Population.CreatureObserver;

public class DeadState implements State{
    private Creature creature;
    public DeadState(Creature creature){
        this.creature = creature;
    }
    /**
    Notifies the population of the creatures state */
    @Override
    public void doAction() {
        CreatureObserver observer = this.creature.getObserver(0);
        this.creature.notify(observer,-1);
    };
}