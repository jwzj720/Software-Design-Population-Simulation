package Population;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import Organism.Location;
import Organism.Creature.*;
import java.awt.*;

public class PopulationInstantiator {
    /**
     * Instantiates a new population of creatures
     * @param popSize starting size of population
     * @param location starting location of the creatures in the population
     * @param shape shape of creatures in the pop
     * @param color color of the creatures in the pop
     * @param size size of creatures in the pop
     * @param priorities list of creature priorities
     * @param prey list of the objects this population may prey upon
     * @return Population object
     */
    public Population instantiatePopulation(String name, int popSize, Location location, String shapeString, Color color,
                                            int size, ArrayList<Object> priorities,
                                            List<String> prey){
        Population population = new Population();
        population.setPopSize(popSize);
        population.setName(name);
        CreatureBuilder CB =  new CreatureBuilder();
        for(int i = 0; i < popSize; i++){
            Creature newCreature = CB.buildCreature(location, color, shapeString,
                                                    size, priorities, prey, population,population);
        }
        //Need to reset population size here because it gets changed adding new creatures
        population.setPopSize(population.getCreatures().size()); 
        return population;
    }
}
