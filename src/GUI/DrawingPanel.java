package GUI;

import javax.swing.JFrame;

import Organism.Creature.Creature;
import Organism.Food.Food;
import Organism.Food.FoodPopulation;
import Population.Population;

import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.awt.*;


public class DrawingPanel extends JPanel
{
    //take in up to three populations
    //somehow 
 
    private Population populationOne;
    private Population populationTwo;
    private Population populationThree;
    private FoodPopulation defaultFood;

    /**
    Drawing Panel for two population instances */
    public DrawingPanel(Population populationOne, Population populationTwo, FoodPopulation defaultFood)
    {
        this.populationOne = populationOne;
        this.populationTwo = populationTwo;
        this.populationThree = null;
        this.defaultFood = defaultFood;

    }

    public DrawingPanel(Population populationOne, Population populationTwo, Population populationThree, FoodPopulation defaultFood)
    {
        this.populationOne = populationOne;
        this.populationTwo = populationTwo;
        this.populationThree = populationThree;
        this.defaultFood = defaultFood;
    
    }

    /**
    Makes the window appear
    @param Graphics g */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);

    }

    /**
     * Draws organisms to board
     * @param g */
    private void doDrawing(Graphics g) {
        /* 
        var g2d = (Graphics2D) g;
        g2d.setColor(Color.blue); 
        g2d.fillOval(100, 100, 500, 500);
        */
        if(populationOne != null)
        {
            for(Creature c : populationOne.getCreatures())
            {
                c.draw(g);
            }
        }
        if(populationTwo != null)
        {
            for(Creature c : populationTwo.getCreatures())
            {
                c.draw(g);
            }
        }
        if(populationThree != null)
        {
            for(Creature c : populationThree.getCreatures())
            {
                c.draw(g);
            }
        }
        
        if(defaultFood != null){
            for (Food f : defaultFood.getFoodList()){
                f.draw(g);
            }
        }

    }
    
    /**
    Sets the dimensions for the simulation window */
    @Override
    public Dimension getPreferredSize() {
        int width = 1000;
        int height = 700+29;
        return new Dimension(width, height);
    }   
        
    
}