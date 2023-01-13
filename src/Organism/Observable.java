package Organism;

import java.util.ArrayList;

import Population.CreatureObserver;

public interface Observable {
    public void register(CreatureObserver creatureObserver);
    public void unregister(CreatureObserver creatureObserver);
    public void notify(CreatureObserver creatureObserver,Object arg);
    public void notifyAll( Object arg);
}