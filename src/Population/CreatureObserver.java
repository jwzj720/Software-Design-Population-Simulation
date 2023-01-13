package Population;

import Organism.Creature.Creature;

public interface CreatureObserver {
    public void update(Creature observable,Object arg);
}
