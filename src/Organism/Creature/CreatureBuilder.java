package Organism.Creature;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Organism.Location;
import Organism.Creature.State.SicklyState;
import Organism.Creature.State.State;
import Population.CreatureObserver;
import Population.Population;

public class CreatureBuilder {
    public CreatureBuilder(){}
    /**
     * Instantiates a new creature object
     * @return creature object
     */
    public Creature buildCreature(Location location,
                                    Color color,String shapeString, int size, ArrayList<Object> priorities,
                                    List<String> prey, CreatureObserver creatureObserver,Population population){
        Creature creature =  new Creature();
        AI creatureBehavoir = new AI(priorities);
        creature.setLocation(location);
        //creature.setShape(shape);
        creature.setColor(color);
        creature.setSize(size);
        creature.setCurrentState(new SicklyState(creature));
        creature.setHealth(49);// Setting health also changes state
        creature.setPriorities(priorities);
        creature.setPrey(prey);
        creature.setBehavior(creatureBehavoir);
        creature.setShapeString(shapeString);
        creature.setPopulation(population);
        
        creature.register(creatureObserver);
        creature.notifyAll(1); // Adds the creature to all observer
        return creature;
    }


}
