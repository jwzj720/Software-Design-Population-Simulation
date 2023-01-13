package Organism.Creature;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;
import Organism.Location;
import Organism.*;
import Organism.Creature.State.*;
import Population.CreatureObserver;
import Population.Population;

public class Creature extends Organism implements Observable{
    private Location location;
    private State currentState;
    private Color color;
    private String shapeString;
    private int size;
    private double health;
    private ArrayList<Object> priorities;
    private List<String> prey;
    private AI behavior; 
    private ArrayList<CreatureObserver> observers = new ArrayList<CreatureObserver>();
    private boolean canReproduce = false;
    private Population population;

    public Creature(){};
    /**
     * Moves the creature to a new location based on the AI
     */
    public void move(){
        Location newLocation = this.behavior.getLocationToMoveTo(this);
        this.location = newLocation;
    }
    public void draw(Graphics g) {
        // If we want coordinates to be in the center we have to displace the circle 
        // by half its width and height
        int xPos = this.location.getX() - (this.size/2);
        int yPos = this.location.getY() - (this.size/2);
        g.setColor(this.color);
        if(this.shapeString.equals("circle")){
            g.fillOval(xPos, yPos, this.size, this.size);
        }else if(this.shapeString.equals("square")){
            g.fillRect(xPos, yPos, this.size, this.size);
        }else if(this.shapeString.equals("triangle")){
            int[] xVals = new int[]{(int) (xPos-(0.5*size)),xPos,(int) (xPos+(0.5*size))}; 
            int[] yVals = new int[]{(int) (yPos-((Math.sqrt(3)/2)*size)),yPos+size,(int) (yPos+((Math.sqrt(3)/2)*size))}; 
            g.fillPolygon(xVals, yVals, 3);;
        }   
    }
    // Setter and Getter Methods
    /**
     * Gets the creature's current location
     * @return Location object containing an x and y coordinate
     */
    public Location getLocation(){
        return this.location;
    }
    /**
     * Sets the creature's current location
     * @param Location object containing an x and y coordinate
     */
    public void setLocation(Location location){
        this.location = location;
    }
    /**
     * Gets the Creatures current state
     * @return currentState
     */
    public State getCurrentState() {
        return this.currentState;
    }
    /**
     * Sets the creature's current state
     * @param currentState of the the creature, either alive dead or sickly
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    /**
     * Get's the creature's color
     * @return Color object of the creature
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * Sets the creature's color 
     * @param color object to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    /**
     * Gets the creatures shape 
     * @return shape object associated with the creature
     */
    public String getShapeString() {
        return this.shapeString;
    }
    /**
     * Sets the creature's shape
     * @param shape object to set
     */
    public void setShapeString(String shapeString) {
        this.shapeString = shapeString;
    }
    /**
     * Gets the creature's size
     * @return int of creature's size
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Sets creature's size
     * @param size int corresponding to creature's drawn size
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     * Gets creature's current health
     * @return creature's health
     */
    public double getHealth() {
        return health;
    }
    /**
     * Sets creature's health
     * @param health of creature
     */
    public void setHealth(double health) {
        this.health = health;
        this.currentState.doAction();
    }
    /**
     * Gets a list of objects in order of priority. Priority defines the order with
     * which the creature will pursue these objects. Objects can be either Food, creatures
     * from the same population, or creatures from different populations.
     * @return list of ordered objects 
     */
    public ArrayList<Object> getPriorities() {
        return this.priorities;
    }
    /**
     * Sets the creatures priorities. Priorities are a list of objects. Priority defines the order with
     * which the creature will pursue these objects. Objects can be either Food, creatures
     * from the same population, or creatures from different populations.
     * @param priorities list of ordered objects
     */
    public void setPriorities(ArrayList<Object> priorities) {
        this.priorities = priorities;
    }
    /**
     * Get's the list of the creature's prey. This list constitutes what the creature will move towards
     * and try to eat. Prey can be creatures from other populations or food objects 
     * @return list of objects
     */
    public List<String> getPrey() {
        return this.prey;
    }
    /**
     * Sets the list of the creature's prey. This list constitutes what the creature will move towards
     * and try to eat. Prey can be creatures from other populations or food objects 
     * @param prey list of objects 
     */
    public void setPrey(List<String> prey) {
        this.prey = prey;
    }
    /**
     * Gets the AI object that determines a creature's behavior
     * @return AI object
     */
    public AI getBehavior() {
        return this.behavior;
    }
    /**
     * Sets the AI object that determines the creature's behavoir
     * @param behavior AI object that dictates how the creature moves and acts
     */
    public void setBehavior(AI behavior) {
        this.behavior = behavior;
    }
    /**
     * Registers a new CreatureObserver
     * @param creatureObserver
     */
    @Override
    public void register(CreatureObserver creatureObserver) {
        this.observers.add(creatureObserver);  
    }
    /**
     * Unregisters a CreatureObserver
     * @param CreatureObserver
     */
    @Override
    public void unregister(CreatureObserver creatureObserver) {
        this.observers.remove(creatureObserver);    
    }
    /**
     * Notifies an observer about some change
     * @param creatureObserver
     * @param arg argument corresponding to the change to be enacted
     */
    @Override
    public void notify(CreatureObserver creatureObserver, Object arg) {
        creatureObserver.update(this, arg);
    }
    /**
     * Notifies all observers
     * @param arg argument argument corresponding to the change to be enacted
     */
    @Override
    public void notifyAll(Object arg) {
        for(CreatureObserver CO: this.observers){
            CO.update(this, arg);
        }
    }
    /** returns the list of all creature observers
     * @return ArrayList<CreatureObserver>
     */
    public ArrayList<CreatureObserver> getAllObservers(){
        return this.observers;
    }
    /** Gets a specific observer from the array list by index
     * @param index the specific index for the observer
     * @return CreatureObserver
     */
    public CreatureObserver getObserver(int index){
        return this.observers.get(index);
    }
	/** Sets whether or not the creature can reproduce depending on its state
	 * @param b whether or not the creature can reproduce
	 */
	public void setCanReproduce(boolean b) {
        this.canReproduce = b;
	} 
    /** returns whether a creature can reproduce or not
     * @return boolean
     */
    public boolean getCanReproduce(){
        return this.canReproduce;
    }
    /** returns the population of the creature
     * @return Population
     */
    public Population getPopulation(){
        return this.population;
    }
    /** sets the population for this creature
     * @param population
     */
    public void setPopulation(Population population){
        this.population = population;
    }
}