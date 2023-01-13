package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Organism.Location;
import Organism.Creature.*;
import Organism.Food.Food;
import Organism.Food.FoodInstantiator;
import Organism.Food.FoodPopulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Population.*;
import Population.Interaction.*;

public class SimulationGUI {
    private Population populationOne;
    private Population populationTwo;
    private Population populationThree;
    private ActionListener timer;
    private DrawingPanel draw;
    private InteractionMediator mediator;
    private FoodPopulation defaultFood;

    /**
    Creates simulation GUI window
    @param Population
    @param Population
    @param FoodPopulation
     */
    public  SimulationGUI(Population populationOne, Population populationTwo, FoodPopulation defaultFood){
        this.populationOne = populationOne;
        this.populationTwo = populationTwo;
        this.defaultFood = defaultFood;

        mediator = new InteractionMediator(); 
        timer = new TimerListener();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame frame = new JFrame("Simulation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                //frame.add(new BasePane());
                draw = new DrawingPanel(populationOne, populationTwo, defaultFood);
                frame.add(draw);
                Timer t = new Timer(20, timer);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                t.start();
            }
            
        });        
    }

    /**
    Updates the GUI frame with time */
    class TimerListener implements ActionListener{   //Consitutes one frame update 
        int seconds = defaultFood.getRegenerationRate();
        int i = 0;
        @Override 
        public void actionPerformed(ActionEvent e) {
            mediator.checkTotalCollisions(populationOne, populationTwo, defaultFood);
            if(populationOne != null)
        {
            for(int i = 0; i < populationOne.getPopSize(); i++)
            {
                Creature c = populationOne.getCreature(i);
                c.move();
                c.setHealth(c.getHealth()-0.1);
            }
        }
        if(populationTwo != null)
        {
            for(int i = 0; i < populationTwo.getPopSize(); i++)
            {
                Creature c = populationTwo.getCreature(i);
                c.move();
                c.setHealth(c.getHealth()-0.1);
            }
        }
        if(populationThree != null)
        {
            for(int i = 0; i < populationThree.getPopSize(); i++)
            {
                Creature c = populationThree.getCreature(i);
                c.move();
                c.setHealth(c.getHealth()-0.1);
            }
        }
        if (defaultFood != null){
            i++;
            if(i % seconds == 0){
                Food f = defaultFood.getFoodList().get(0);
                f.regenerate(defaultFood);
            }   
        }
        draw.repaint();
        }
    }
}
