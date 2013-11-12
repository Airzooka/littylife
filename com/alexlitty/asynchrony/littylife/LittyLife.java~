package com.alexlitty.asynchrony.littylife;

import java.util.Random;

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
        Random gen = new Random();
    
        // Determine cell dimmensions
        cellWidth = windowWidth / gridColumns;
        cellHeight = windowHeight / gridRows;

        // Create grids of cells, all dead by default
        cellsTemp = new boolean[gridColumns * gridRows];
        cells = new boolean[gridColumns * gridRows];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = gen.nextInt(2) == 0 ? true : false;
        }
        
        // Prepare cell colors
        cellColorAlive = new Color(255, 150, 20);
        cellColorDead = new Color(25, 25, 25);
    }
    
    /**
     *
     */
    public int cellIndex(int x, int y) {
        return x + (y * gridColumns);
    }
    
    /**
     * Returns true if a particular cell is alive, false otherwise.
     *
     * Parameters are x and y coordinates where the cell should lie visually,
     * starting at (0, 0).
     *
     * If the coordinate is out of range of the grid, returns false.
     */
    protected boolean cellIsAlive(int x, int y) {
        if (x < 0 || y < 0 || x > (gridColumns - 1) || y > (gridColumns - 1)) {
            return false;
        }
        return cells[x + (y * gridColumns)];
    }
    
    /**
     * Counts the live neighbors around a given cell.
     */
    protected int cellNeighbors(int x, int y) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (cellIsAlive(x + i, y + j)) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    /**
     * Perform an update on the current game logic.
     */
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        int neighbors, x;
        
        // Bring cells into the next generation
        for (int i = 0; i < gridColumns; i++) {
            for (int j = 0; j < gridRows; j++) {
                x = cellIndex(i, j);
                neighbors = cellNeighbors(i, j);
                
                // Live cell
                if (cellIsAlive(i, j)) {
                    if (neighbors < 2 || neighbors > 3) {
                        cellsTemp[x] = false;
                    } else {
                        cellsTemp[x] = true;
                    }
                }
                
                // Dead cell
                else {
                    cellsTemp[x] = (neighbors == 3) ? true : false;
                }
            }
        }
        
        // Bring next generation cells into current generation
        for (int i = 0; i < cells.length; i++) {
            cells[i] = cellsTemp[i];
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
                if (cellIsAlive(i, j)) {
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
            app.setTargetFrameRate(10);
            app.start();
        }
        catch (SlickException e) {
            System.out.println("Slick2D Exception: " + e.getMessage());
        }
    }
}
