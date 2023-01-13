package Population.Interaction;

import Organism.Creature.Creature;
import Organism.Creature.CreatureBuilder;
import Organism.Creature.State.*;
import Organism.Food.Food;
import Organism.Food.FoodPopulation;
import Population.*;

public class Interaction{ 
    /**
     * This method takes in two of the same species and creates another one
     * @param creatureOne
     * @param creatureTwo
     */
    public void reproduction(Creature creatureOne, Creature creatureTwo){
        if(creatureOne.getCanReproduce()){
            CreatureBuilder CB = new CreatureBuilder();
            Creature newCreature = CB.buildCreature(creatureOne.getLocation(), 
            creatureOne.getColor(),creatureOne.getShapeString(), creatureOne.getSize(),  creatureOne.getPriorities(),
             creatureOne.getPrey(),creatureOne.getObserver(0),creatureOne.getPopulation());
            creatureOne.setHealth(49);
            creatureTwo.setHealth(49);
        }
    };
    /**
     * This method adds health to a creature when it encounters food.
     * Also gets rid of the food
     * @param creatureOne
     * @param food
     */
    public void eatFood(Creature creatureOne, FoodPopulation foodPop, Food food){
        foodPop.removeCreature(food);
        if (creatureOne.getHealth() != 100){
            creatureOne.setHealth(100);
        }  
    };
    /**
     * This method should get rid of all references to the creature
     * @param creatureOne
     */
    public void eatCreature(Creature creatureOne, Creature creatureTwo){
        if(creatureOne.getPrey().contains(creatureTwo.getPopulation().getName())){
            creatureOne.setHealth(100);
            creatureTwo.setHealth(0);
        }else if(creatureTwo.getPrey().contains(creatureTwo.getPopulation().getName())){
            creatureTwo.setHealth(100);
            creatureOne.setHealth(0);
        }
    };

}