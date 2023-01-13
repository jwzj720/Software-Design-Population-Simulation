package Population;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Organism.Creature.*;

public class Population implements CreatureObserver{
    ArrayList<Creature> creatures = new ArrayList<Creature>();
    int popSize;
    String name;
    /**
     * Gets the list of creatures that make up a population
     * @return ArrayList of creatures
     */
    public ArrayList<Creature> getCreatures() {
        return this.creatures;
    }
    /**
     * Get's a specific creature at index i
     * @param i the index
     * @return returns the creature at that index
     */
    public Creature getCreature(int i){
        return creatures.get(i);
    }
    /**
     * Sets the population's name
     * @param newName
     */
    public void setName(String newName){
        this.name = newName;
    }
    /**
     * Gets the populations name
     * @return name String
     */
    public String getName(){
        return this.name;
    }
    /**
     * Sets the creatures in the population
     * @param creatures that make up the population
     */
    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }
    /**
     * Adds a creature to the population
     * @param creature
     */
    public void addCreature(Creature creature){
        this.popSize++;
        this.creatures.add(creature);
    }
    /**
     * Gets the total number of creatures in the populatiom
     * @return int number of creatures in the population
     */
    public int getPopSize() {
        return popSize;
    }
    /**
     * Sets the size of the population
     * @param popSize number of creatures in the population
     */
    public void setPopSize(int popSize) {
        this.popSize = popSize;
    }
    /**
     * Removes a creature from the population
     * @param creature creature to be removed
     */
    public void removeCreature(Creature creature){
        this.popSize--;
        this.creatures.remove(creature);
    }
    /** updates a creature either by adding or removing
    @param Creature observable creature
    @param Object determines whether to add or remove creature
     */
	public void update(Creature observable,Object arg) {
        if(arg.equals(-1)){
            this.removeCreature(observable);
        }else if(arg.equals(1)){
            this.addCreature(observable);
        }else{
            String errorMsg = ".update() must be called with either arg=-1 or arg=1";
            throw new IllegalArgumentException(errorMsg);
        }
	}
    
}
