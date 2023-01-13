package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.ResourceBundle.Control;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Organism.Food.FoodPopulation;
import Population.Population;

public class BasePane extends JPanel {

    private JTextArea species;
    private DrawingPanel simulation;
   

    private JDesktopPane desktopPane;


    /**Constructor for BasePane class
     */
    public BasePane() {              
        setLayout(new BorderLayout());
        desktopPane = new JDesktopPane();
        species = new JTextArea("Species");
        JPanel controls = new JPanel(new GridLayout(1, 1));
        controls.add(new JScrollPane(species));
        add(controls, BorderLayout.WEST);
       // simulation.setBackground(new Color(255, 200, 20));
    }


    /**
    Runs simulation based on two population instances
    @param Population first population
    @param Population second population
     */
    public BasePane(Population one, Population two, FoodPopulation food) {     
                   
        setLayout(new BorderLayout());

        desktopPane = new JDesktopPane();


        species = new JTextArea("Species");
        simulation = new DrawingPanel(one, two, food);
        JPanel controls = new JPanel(new GridLayout(1, 1));
        controls.add(new JScrollPane(species));
        add(controls, BorderLayout.WEST);
        add(simulation);
       // simulation.setBackground(new Color(255, 200, 20));
        simulation.repaint();
    }

    /**
    Runs the simulation with three population instances
    @param Population
    @param Population
    @param Population
     */
    public BasePane(Population one, Population two, Population three, FoodPopulation food) {     
                   
        setLayout(new BorderLayout());

        desktopPane = new JDesktopPane();


        species = new JTextArea("Species");
        simulation = new DrawingPanel(one, two, three, food);
        JPanel controls = new JPanel(new GridLayout(1, 1));
        controls.add(new JScrollPane(species));
        add(controls, BorderLayout.WEST);
        add(simulation);
       // simulation.setBackground(new Color(255, 200, 20));
        simulation.repaint();
    }

    /**
    Sets dimension of the simulation window */
    @Override
    public Dimension getPreferredSize() {
        int width = 1000;
        int height = 700+29;
        return new Dimension(width, height);
    }            
}   
