# Lucky Penguins Project 2

## Population Dynamics Simulation
The simulation program shows how population sizes change as predator, prey, and food populations interact. The simulation takes in user input that defines what the creatures of a population will look like on the simulation and which populations are their prey. The creatures will randomly move around on the graphical user interface window, while the food is stationary in random locations. When two objects collide, they will have one of three interactions. If two creatures of the same species collide, they may reproduce and another creature of the same type will appear. If two different species collide and one of them is the prey of the other, then it will get eaten and disappear. If a creature and food collide, then the food will disappear.

When a creature eats another creature or food, it gains health points. Throughout time, the health points will continuously decrease. If a creature's health points reach 0, then the creature will die and disappear from the simulation.

The food objects have a regeneration rate, which determines how often a new food instance will appear on the simulation. This parameter can be inputted by the user.

## Running the Simulation and Entering Parameters

Running the program will open up a window with buttons corresponding to two creature populations and one food type. Clicking these buttons will open up a new window with a set of editable parameters that can be chosen to enter in the simulation. Type a string for the population into the name textfield. Select from the drop down menus the visual parameters for the populations.

To select a starting population size, enter an integer with no spaces into the corresponding textfield.

To list the prey of a population, list the names of the prey populations with no spaces, and separated by commas if there is more than one.
