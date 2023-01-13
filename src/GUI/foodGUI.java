package GUI;

import javax.swing.*;

import Organism.Food.Food;
import Organism.Food.FoodInstantiator;
import Organism.Food.FoodPopulation;
import Organism.Location;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class foodGUI extends JFrame implements ActionListener{
    private JLabel food;
    private JLabel color;
    private JLabel size;
    private JLabel shape;
    private JLabel growRate;
    private JLabel popSize;
    private JComboBox<String> colorIn;
    private JComboBox<String> sizeIn;
    private JComboBox<String> shapeIn;
    private JComboBox<String> growRateIn;
    private JTextField popSizeIn;
    private JButton saveInfo;
    private FoodPopulation foodToReturn;

    public void createFood() {

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridwidth = 1;

        // add food title
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0; gc.gridy=0;
        food = new JLabel("Food");
        food.setFont(new Font("The Girl Next Door", Font.PLAIN, 25));
        add(food,gc);

        // add color label and text field
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=1;
        color = new JLabel("Color:");
        color.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(color,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 1;
        String[] colorOptions = {"black","blue","cyan","gray","green","magenta",
        "orange","pink","red","yellow"};
        colorIn = new JComboBox<String>(colorOptions);
        colorIn.setEditable(false);
        colorIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(colorIn,gc);

        // add size label and text field
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=2;
        size = new JLabel("Size:");
        size.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(size,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 2;
        String[] sizeOptions = {"small","medium","large"};
        sizeIn = new JComboBox<String>(sizeOptions);
        sizeIn.setEditable(false);
        sizeIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(sizeIn,gc);

        // add shape label and textfield
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=3;
        shape = new JLabel("Shape:");
        shape.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(shape,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 3;
        String[] shapeChoices = {"triangle","circle","square"};
        shapeIn = new JComboBox<String>(shapeChoices);
        shapeIn.setEditable(false);
        shapeIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(shapeIn,gc);

        // add reproduction rate label and text field
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=4;
        growRate = new JLabel("Regrowth Rate:");
        growRate.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(growRate,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 4;
        String[] growRateChoices = {"very fast","fast", "medium","slow","very slow"};
        growRateIn = new JComboBox<String>(growRateChoices);
        growRateIn.setEditable(false);
        growRateIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(growRateIn,gc);

        // add population starting size label and textfield
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=5;
        popSize = new JLabel("Starting Population Size");
        popSize.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(popSize,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 5;
        popSizeIn = new JTextField(30);
        popSizeIn.setText("Enter the Starting Size of the Population (Integer)");
        popSizeIn.setEditable(true);
        popSizeIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(popSizeIn,gc);

        // add save info button
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 1; gc.gridy = 6;
        saveInfo = new JButton("Save Data");
        saveInfo.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        saveInfo.setBackground(new Color(51,204,255));
        saveInfo.setOpaque(true);
        saveInfo.setBorderPainted(false);
        saveInfo.setEnabled(true);
        saveInfo.addActionListener(this);
        add(saveInfo,gc);

    }

    public FoodPopulation getUserCreatedFood(){
        return this.foodToReturn;
    }

    public foodGUI(){
        super();
        GridBagLayout gl = new GridBagLayout();
        setLayout(gl);
        createFood();
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //size
        String sizeString = (String)sizeIn.getSelectedItem();
        int newSize;
        if (sizeString.equals("small")){
            newSize = 10;
        }
        else if (sizeString.equals("medium")){
            newSize = 15;
        }
        else if (sizeString.equals("large")){
            newSize = 20;
        }
        else{
            newSize = 0;
        }
        //regeneration rate
        String growRateString = (String)growRateIn.getSelectedItem();
        int newGrowRate=1;
        if (growRateString.equals("very slow")){
            newGrowRate = 50;
        }
        else if (growRateString.equals("slow")){
            newGrowRate = 40;
        }
        else if (growRateString.equals("medium")){
            newGrowRate = 30;
        }
        else if (growRateString.equals("fast")){
            newGrowRate = 20;
        }
        else if (growRateString.equals("very fast")){
            newGrowRate = 10;
        }
        //color
        String colorString = (String)colorIn.getSelectedItem();
        Color newColor;
        try {
            newColor = (Color)Color.class.getField(colorString.toUpperCase()).get(null);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
            e1.printStackTrace();
            newColor = null;
        }
        //shape
        String shapeString = (String)shapeIn.getSelectedItem();
        Shape newShape;
        if (shapeString.equals("circle")){
            newShape = null;
        }
        else if (shapeString.equals("triangle")){
            newShape = null;
        }
        else if (shapeString.equals("square")){
            newShape = null;
        }
        else {
            newShape = null;
        }
        //location
        Random rand = new Random();
        int randomX = rand.nextInt(1000);
        int randomY = rand.nextInt(729);
        Location randomLoc = new Location(randomX,randomY);
        //starting population size
        int initialSize = Integer.valueOf(popSizeIn.getText());
        //make new food
        FoodInstantiator newFI = new FoodInstantiator();
        FoodPopulation newFood = newFI.instantiateFood(initialSize,newSize,newGrowRate,newColor,newShape,"Food",randomLoc);
        this.foodToReturn = newFood;
    }

}
