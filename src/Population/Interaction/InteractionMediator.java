package Population.Interaction;

import Population.Population;
import Organism.*;
import Organism.Food.FoodPopulation;

public class InteractionMediator{
    Population populationOne, populationTwo;
    FoodPopulation food;
    /**
     * Checks collisons amongst both populations
     * @param populationOne
     * @param populationTwo
     * @param food
     */
    public void checkTotalCollisions(Population populationOne, Population populationTwo, FoodPopulation food){
        checkCollisionBetweenpopulations(populationOne, populationTwo);
        checkCollisionWithinPopulation(populationOne);
        checkCollisionWithinPopulation(populationTwo);
        checkCollisionBetweenFood(populationOne, food);
        checkCollisionBetweenFood(populationTwo, food);
    }
    /**
     * Checks for a collision between organisms
     * @param organismOne
     * @param organismTwo
     * @return boolean depending on if a collision occurred or not
     */
    public boolean checkCollision(Organism organismOne, Organism organismTwo){
        Location locOne = organismOne.getLocation();
        Location locTwo = organismTwo.getLocation();
        double distance  = locOne.getDistanceTo(locTwo);
        // Organisms intersect
        if (distance < organismOne.getSize() + organismTwo.getSize()) {
           return true;
        }
        // Organisms touch edges
        else if (distance == organismOne.getSize() + organismTwo.getSize()) {
            return true;
        }
        // Organisms don't touch
        else {
            return false;
        }
    }
    
    /** checks for collisions of between creatures within the same population
     * @param population
     */
    public void checkCollisionWithinPopulation(Population population){
        for(int i = 0; i < population.getPopSize(); i++){
            for(int j = 0; j < population.getPopSize(); j++){
                if(checkCollision(population.getCreature(i), population.getCreature(j))){
                    Interaction interaction  = new Interaction();
                    interaction.reproduction(population.getCreature(i), population.getCreature(j));
                }
            }
         }
    }

    /** Checks for collision between two different populations
     * @param populationOne
     * @param populationTwo
     */
    public void checkCollisionBetweenpopulations(Population populationOne, Population populationTwo){
        for(int i = 0; i < populationOne.getPopSize(); i++){
            for(int j = 0; j < populationTwo.getPopSize(); j++){
                if(checkCollision(populationOne.getCreature(i), populationTwo.getCreature(j))){
                    Interaction interaction  = new Interaction();
                    interaction.eatCreature(populationOne.getCreature(i),  populationTwo.getCreature(j));
                }
            }  
        }
    }

    public void checkCollisionBetweenFood(Population population, FoodPopulation food){
        for(int i = 0; i < population.getPopSize(); i++){
            for(int k = 0; k < food.getQuantity(); k++){
                Interaction interaction = new Interaction();
                try{
                    if(checkCollision(population.getCreatures().get(i), food.getFoodList().get(k))){
                        interaction.eatFood(population.getCreatures().get(i), food, food.getFoodList().get(k));
                    }
                }
                catch(IndexOutOfBoundsException e){}
            }
        }
    }
    
}