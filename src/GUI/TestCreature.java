package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class TestCreature {
    private int width;
    private int height;
    
    /**
    sets dimensions to creature
    @param int width
    @param int height
     */
    public TestCreature(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    /**
    draws the creatures onto the simulation screen
    @param Graphics g
     */
    public void draw(Graphics g) 
    {
		g.setColor(Color.MAGENTA);
		g.fillRect(width, height, width, height);
	}
}
