package Organism.Food;

import java.util.ArrayList;

public class FoodPopulation {
    ArrayList<Food> foodList;
    int quantity;
    int regenerationRate;

     /**
     * Gets the list of foods that are on map
     * @return ArrayList of creatures
     */
    public ArrayList<Food> getFoodList() {
        return this.foodList;
    }

    /**
     * Sets the food list
     * @param list of food that should be on map 
     */
    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    /**
     * Adds food to the list
     * @param food
     */
    public void addFood(Food food){
        this.quantity++;
        this.foodList.add(food);
    }

     /**
     * Gets the total number of food on map
     * @return int number of food on map
     */
    public int getQuantity() {
        return this.quantity;
    }
    /**
     * Sets the quantity of food
     * @param quantity number of food on map
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the regeneration rate of food
     * @return the regeneration rate
     */
    public int getRegenerationRate(){
        return this.regenerationRate;
    }
   
    /** 
     * Sets the regeneration rate of food
     * @param regenerationRate
     */
    public void setRegenerationRate(int regenerationRate){
        this.regenerationRate = regenerationRate;
    }

    /**
     * Removes a creature from the population
     * @param creature
     */
    public void removeCreature(Food food){
        this.quantity--;
        this.foodList.remove(food);
    }
}
