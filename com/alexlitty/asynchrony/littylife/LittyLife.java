package com.alexlitty.asynchrony.littylife;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class LittyLife extends BasicGame
{
    // Size of the game window.
    protected static int windowWidth = 600;
    protected static int windowHeight = 600;
    
    // Number of rows and columns on the cell grid.
    protected static int gridColumns = 60;
    protected static int gridRows = 60;

    // Collection of boolean values representing cells. Dead if false.
    protected boolean[] cells;
    
    // Stores the next generation of cells temporarily.
    protected boolean[] cellsTemp;
    
    // Information to visually represent cells
    protected int cellWidth;
    protected int cellHeight;
    protected Color cellColorAlive;
    protected Color cellColorDead;
    
    /**
     * Game constructor. Initializes the class, not the game.
     *
     * Calls the parent class constructor.
     */
    public LittyLife(String gamename) {
        super(gamename);
    }

    /**
     * Initializes critical game components.
     *
     * Prepares a grid of cells and their visual representations.
     */
    @Override
    public void init(GameContainer gc) throws SlickException {
        Graphics gtemp;
        
        // Calculate cell dimmensions
        cellWidth = windowWidth / gridColumns;
        cellHeight = windowHeight / gridRows;

        // Create a grid of cells    
        cells = new boolean[gridColumns * gridRows];
        for (boolean c : cells) {
            c = false;
        }
        cells[22] = true;
        
        // Prepare cell colors
        cellColorAlive = new Color(0, 0, 0);
        cellColorDead = new Color(255, 255, 255);
    }
    
    /**
     * Returns true if a particular cell is alive, false otherwise.
     *
     * Parameters are x and y coordinates where the cell should lie visually,
     * starting at (0, 0).
     */
    public boolean isAlive(int x, int y) {
        return cells[x + (y * gridColumns)];
    }

    /**
     * Perform an update on the current game logic.
     */
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        
    
        for (int i = 0; i < cells.length; i++) {
            if (
        }
    }

    /**
     * Graphically render the current state of the game.
     *
     * Instead of painting each individual cell, the dead cell color is painted
     * across the window. Living cells are then drawn individually.
     */
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(cellColorDead);
        g.fillRect(0, 0, windowWidth, windowHeight);
        
        // Draw living cells
        g.setColor(cellColorAlive);
        for (int i = 0; i < gridColumns; i++) {
            for (int j = 0; j < gridColumns; j++) {
                if (isAlive(i, j)) {
                    g.fillRect(
                        i * cellWidth,
                        j * cellHeight,
                        cellWidth,
                        cellHeight
                    );
                }
            }
        }
    }

    /**
     * Litty's Game of Life entry function.
     */    
    public static void main(String[] args)
    {
       try {
            AppGameContainer app;
            app = new AppGameContainer(new LittyLife("Litty's Game of Life"));
            app.setDisplayMode(windowWidth, windowHeight, false);
            app.start();
        }
        catch (SlickException e) {
            System.out.println("Slick2D Exception: " + e.getMessage());
        }
    }
}
