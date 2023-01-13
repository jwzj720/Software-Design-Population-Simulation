package Organism.Food;

import java.util.ArrayList;

import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import Organism.*;

public class FoodInstantiator {

    /**
     * Creates food instance
     * @param quantity
     * @param size
     * @param regenerationRate
     * @param color
     * @param shape
     * @param name
     * @param location
     * @return
     */
    public FoodPopulation instantiateFood(int quantity, int size, int regenerationRate, Color color, Shape shape, String name, Location location){
        FoodPopulation allTheFood = new FoodPopulation(); 
        
        allTheFood.setQuantity(quantity);
        allTheFood.setRegenerationRate(regenerationRate);
        ArrayList<Food> listOfFood = new ArrayList<>();
        allTheFood.setFoodList(listOfFood);

        Food food = new Food(quantity, size, regenerationRate, color, shape, name, location);
        listOfFood.add(food);
        allTheFood.setFoodList(listOfFood);
        for (int i = 1; i < quantity; i++){
            food.regenerate(allTheFood);
        }
        allTheFood.setFoodList(listOfFood);
        return allTheFood;
    }

}
