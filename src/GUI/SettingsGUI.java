package GUI;

import java.util.ArrayList;
import java.util.Timer;
import java.util.ResourceBundle.Control;

import javax.swing.*;

import Organism.Food.FoodPopulation;
import Population.Population;

import java.awt.*;
import java.awt.event.*;

public class SettingsGUI extends JFrame implements ActionListener{
    private JLabel welcome;
    private JLabel instruct;
    private JButton popOneInputButton;
    private JButton pop2;
    private JButton pop3;
    private JButton food;
    private JButton start;
    private Population populationOne;
    private Population populationTwo;
    private FoodPopulation foodPopulation;
    private InputPopulationGUI IPG1;
    private InputPopulationGUI IPG2;
    private foodGUI FG;

    /**
    main function that opens the settings window and calls all the other functions through buttons
    @param String[] args
     */
    public static void main(String[] args){
        new SettingsGUI();
    }
    /*
     * Constructs componenets of the settings window
     */
    public void createSettings(){

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridwidth = 1;

        // add label with welcome message
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0; gc.gridy=1;
        welcome = new JLabel("Welcome to PDS!");
        welcome.setFont(new Font("The Girl Next Door", Font.PLAIN, 25));
        add(welcome,gc);

        // add instruction label
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx=0; gc.gridy=2;
        instruct = new JLabel("Click on a population to edit its parameters.");
        instruct.setFont(new Font("The Girl Next Door", Font.PLAIN, 20));
        add(instruct,gc);

        // add population labels
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx=0; gc.gridy=3;
        popOneInputButton = new JButton(new AbstractAction("add") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                IPG1 = new InputPopulationGUI(1); // Get input for population one
                IPG1.setVisible(true);
            }
        });
        popOneInputButton.setText("Population 1");
        popOneInputButton.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        popOneInputButton.setEnabled(true);
        //popOneInputButton.addActionListener(this); //should open new window for pop 1
        add(popOneInputButton,gc);
        
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx=0; gc.gridy=4;
        pop2 = new JButton("Population 2");
        pop2.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        pop2.setEnabled(true);
        pop2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                IPG2 = new InputPopulationGUI(2); // Get input for population two
                IPG2.setVisible(true);
            }
        }); //should open new window for pop 2
        add(pop2,gc);
        /*
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx=0; gc.gridy=5;
        pop3 = new JButton("Population 3");
        pop3.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        pop3.setEnabled(true);
        pop3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                new inputPopulationGUI(3).setVisible(true);// Get input for population two
            }
        }); 
        
        //should open new window for pop 3
        add(pop3,gc);
        */
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx=0; gc.gridy=6;
        food = new JButton("Food");
        food.setFont(new Font("The Girl Next Door", Font.PLAIN, 15));
        food.setEnabled(true);
        food.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                FG = new foodGUI();
                FG.setVisible(true);
                //new foodGUI().setVisible(true);
            }
        }); //should open window for food
        add(food,gc);
        
        // add start simulation button
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx=0; gc.gridy=7;
        start = new JButton("Run Simulation");
        start.setFont(new Font("The Girl Next Door", Font.PLAIN, 35));
        start.setBackground(new Color(102,255,102));
        start.setOpaque(true);
        start.setBorderPainted(false);
        start.setEnabled(true);
        start.addActionListener(this);
        add(start,gc);
    }
    /*
     * Constructor for the settings GUI window
     */
    public SettingsGUI(){
        super();
        GridBagLayout gl = new GridBagLayout();
        setLayout(gl);
        createSettings();
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    /**
     * Action Listener method for running the simulation
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // this will run the simulation by taking in the parameters and open the simulation window
        populationOne = IPG1.getUserCreatedPopulation();
        populationTwo = IPG2.getUserCreatedPopulation();
        foodPopulation = FG.getUserCreatedFood();
        SimulationGUI g = new SimulationGUI(this.populationOne, this.populationTwo, this.foodPopulation);
    }
}