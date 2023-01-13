package GUI;

import java.util.*;
import java.util.List;

import javax.swing.*;
import java.lang.Object.*;
import Organism.Location;
import Population.Population;
import Population.PopulationInstantiator;

import java.awt.*;
import java.awt.event.*;

public class InputPopulationGUI extends JFrame implements ActionListener{
    private JLabel popNum;
    private JLabel name;
    private JLabel color;
    private JLabel shape;
    private JLabel size;
    private JLabel popSize;
    private JLabel prey;
    private JTextField nameIn;
    private JComboBox<String> colorIn;
    private JComboBox<String> shapeIn;
    private JComboBox<String> sizeIn;
    private JTextField popSizeIn;
    private JTextField preyIn;
    private JButton saveInfo;
    private Population populationToReturn;
    
    public void getPopulationInput(int populationNumber){

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridwidth = 1;

        // add window title with population number
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0; gc.gridy=0;
        popNum = new JLabel("Population "+populationNumber);
        popNum.setFont(new Font("The Girl Next Door", Font.PLAIN, 25));
        add(popNum,gc);

        // add name label and textfield
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0; gc.gridy=1;
        name = new JLabel("Name:");
        name.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(name,gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1; gc.gridy = 1;
        nameIn = new JTextField(15);
        nameIn.setText("Enter the Population Name");
        nameIn.setEditable(true);
        nameIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(nameIn,gc);

        // add color label and textfield
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=2;
        color = new JLabel("Color:");
        color.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(color,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 2;
        String[] colorOptions = {"black","blue","cyan","gray","green","magenta",
        "orange","pink","red","yellow"};
        colorIn = new JComboBox<String>(colorOptions);
        colorIn.setEditable(false);
        colorIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(colorIn,gc);

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

        // add size label and textfield
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=4;
        size = new JLabel("Size");
        size.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(size,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 4;
        String[] sizeOptions = {"small","medium","large"};
        sizeIn = new JComboBox<String>(sizeOptions);
        sizeIn.setEditable(false);
        sizeIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(sizeIn,gc);

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

        // add prey list label and textfield
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0; gc.gridy=6;
        prey = new JLabel("Prey");
        prey.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(prey,gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 1; gc.gridy = 6;
        preyIn = new JTextField(20);
        preyIn.setText("List the prey by name separated by commas");
        preyIn.setEditable(true);
        preyIn.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        add(preyIn,gc);

        // Save Button
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 1; gc.gridy = 7;
        saveInfo = new JButton("Save Data");
        saveInfo.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        saveInfo.setBackground(new Color(51,204,255));
        saveInfo.setOpaque(true);
        saveInfo.setBorderPainted(false);
        saveInfo.setEnabled(true);
        saveInfo.addActionListener(this);
        add(saveInfo,gc);

    }

    public InputPopulationGUI(int i){
        super();
        GridBagLayout gl = new GridBagLayout();
        setLayout(gl);
        getPopulationInput(i);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public Population getUserCreatedPopulation(){
        return this.populationToReturn;
    }

    /**
     * Save button reads the user input to create a new population
     * @param e action of pressing the save button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //name
        String newName = nameIn.getText();
        //color
        String colorString = (String)colorIn.getSelectedItem();
        Color newColor;
        try {
            newColor = (Color)Color.class.getField(colorString.toUpperCase()).get(null);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
            e1.printStackTrace();
            newColor = null;
        }
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
        //starting population size
        int initialSize = Integer.valueOf(popSizeIn.getText());
        //location
        Random rand = new Random();
        int randomX = rand.nextInt(1000);
        int randomY = rand.nextInt(729);
        Location randomLoc = new Location(randomX,randomY);
        //shape
        String shapeString = (String)shapeIn.getSelectedItem();
        //priorities
        ArrayList<Object> newPriorities = null;
        //prey
        String[] preyNamesArray = preyIn.getText().split(",");
        List<String> listOfPreyNames =
            new ArrayList<String>(Arrays.asList(preyNamesArray));
        //List listOfPreyNames = 
        //make the new population
        PopulationInstantiator PI = new PopulationInstantiator();
        Population newPopulation = PI.instantiatePopulation(newName, initialSize, randomLoc, shapeString, 
                                                            newColor, newSize, newPriorities, listOfPreyNames);
        this.populationToReturn = newPopulation;
    }

}
