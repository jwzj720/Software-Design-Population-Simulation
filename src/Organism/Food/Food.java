package Organism.Food;

import java.awt.*;
import Organism.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import Organism.*;

public class Food extends Organism {
    private int size, regenerationRate, healthPoint;
    private Color color;
    private Shape shape;
	private String name;
	private Location location;

    /** Food constructor
     * @param size
     * @param regenertationRate
     * @param healthPoint
     * @param color
     * @param shape
     * @param location
     */
	public Food(int size, int regenerationRate, int healthPoint, Color color, 
				Shape shape, String name, Location location) {
					this.size = size;
					this.regenerationRate = regenerationRate;
					this.healthPoint = healthPoint;
					this.color = color;
					this.shape = shape;
					this.name = name;
					this.location = location;
				}


	/**
	 * Sets the location of the food
	 * @param g
	 */
	public void draw(Graphics g) {
        // If we want coordinates to be in the center we have to displace the circle 
        // by half its width and height
        int circleX = this.location.getX() - (this.size/2);
        int circleY = this.location.getY() - (this.size/2);
        g.setColor(this.color);
        g.fillOval(circleX, circleY, this.size, this.size);
    }

	
	/**
	 * Regenerates new food object in random location
	 * @param FoodPopulation
	 */
	public void regenerate(FoodPopulation foodPop){
		Random rand = new Random();
		int randX = rand.nextInt(1000);
		int randY = rand.nextInt(729);
		
		Food freshFood = new Food(this.size, this.regenerationRate, this.healthPoint, 
		this.color, this.shape, this.name, new Location(randX, randY));
		foodPop.addFood(freshFood);
		foodPop.setFoodList(foodPop.getFoodList());
    }


    /**
     * Gets size of food
	 * @return int size
	 */
	public int getSize() {
		return this.size;
	}

    /**
     * Gets health point of food
     * @return int health point
     */
    public int getHealthPoint() {
        return healthPoint;
    }

	/**
     * Gets color of food
	 * @return color of the food
	 */
	public Color getColor() {
		return this.color;
	}

	/**
     * Sets color of food
	 * @return
	 */
	public Color setColor(Color color) {
		return color;
	}


	/**
     * Gets shape of food
	 * @return
	 */
	public Shape getShape() {
		return this.shape;
	}


	/**
     * Gets regeneration rate of food
	 * @return regeneration rate
	 */
	public int getRegenertationRate() {
		return this.regenerationRate;
	}
	
	/* 
	 * Sets location of food
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/* 
	 * Returns location of food
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}
}