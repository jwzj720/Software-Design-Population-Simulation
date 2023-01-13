package Organism.Creature;

import java.util.ArrayList;
import java.util.Random;

import Organism.Location;

public class AI {
    ArrayList<Object> priorities;
    public AI(ArrayList<Object> priorities){
        this.priorities = priorities;
    }
    /**
     * Inactive Method: based on the populations priorities, the creature will move towards what it prefers
     * @return ArrayList<Object>
     */
    public ArrayList<Object> getAvailableActions(){   
        return null;
    }

    /**
     * Method looks at creatures current 
     * @param creature places this creature in a location
     */
    public Location getLocationToMoveTo(Creature creature){
        Random rand = new Random();
        //random number between 25 and - 25
        int moveMagnitude = 25;
        int newX = creature.getLocation().getX() + rand.nextInt(moveMagnitude + moveMagnitude) - moveMagnitude;
        int newY = creature.getLocation().getY() + rand.nextInt(moveMagnitude + moveMagnitude) - moveMagnitude;
        while(newX<0 || newX>1000){
            newX = creature.getLocation().getX() + rand.nextInt(moveMagnitude + moveMagnitude) - moveMagnitude;
        }  
        while(newY<0 || newY>729){
            newY = creature.getLocation().getY() + rand.nextInt(moveMagnitude + moveMagnitude) - moveMagnitude;
        } 
        return new Location(newX, newY);
    }
}
