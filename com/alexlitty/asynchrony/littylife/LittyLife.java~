package com.alexlitty.asynchrony.littylife;

import java.util.Random;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LittyLife extends BasicGame
{
    protected static int windowWidth = 600;
    protected static int windowHeight = 600;
    
    // Number of rows and columns on the cell grid.
    protected static int gridColumns = 60;
    protected static int gridRows = 60;

    // Collection of boolean values representing cells. Dead if false.
    protected boolean[] cells;
    
    // Stores the next generation of cells temporarily.
    protected boolean[] cellsTemp;
    
    // Information to visually represent cells.
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
     * Prepares a grid of cells for visual representation, and generates the
     * random color for living cells.
     *
     * @param gc Game container automatically passed by Slick2D.
     */
    @Override
    public void init(GameContainer gc) throws SlickException {
        Random gen = new Random();
    
        // Determine cell dimmensions
        cellWidth = windowWidth / gridColumns;
        cellHeight = windowHeight / gridRows;

        // Create grids of cells
        cellsTemp = new boolean[gridColumns * gridRows];
        cells = new boolean[gridColumns * gridRows];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = gen.nextInt(2) == 0 ? true : false;
        }
        
        // Prepare cell colors
        cellColorDead = new Color(25, 25, 25);
        cellColorAlive = new Color(
            200 + gen.nextInt(50),
            50 + gen.nextInt(200),
            100 + gen.nextInt(100)
        );
    }
    
    /**
     * Find the index of a cell in an array, given its grid coordinate.
     *
     * Expects a valid coordinate, otherwise the index will be invalid.
     *
     * @param  x Column of the cell.
     * @param  y Row of the cell.
     * @return   Array index of a particular cell.
     * @see      #cells
     * @see      #cellsTemp
     */
    protected int cellIndex(int x, int y) {
        return x + (y * gridColumns);
    }
    
    /**
     * Verifies whether a particular cell is alive or dead.
     *
     * If the coordinates are out of range, returns false.
     *
     * @param  x Column of the cell.
     * @param  y Row of the cell.
     * @return   True if the cell is alive, false otherwise.
     * @see      #cells
     */
    protected boolean cellIsAlive(int x, int y) {
        if (x < 0 || y < 0 || x > (gridColumns - 1) || y > (gridColumns - 1)) {
            return false;
        }
        return cells[x + (y * gridColumns)];
    }
    
    /**
     * Counts the live neighbors around a given cell.
     *
     * Counting is performed diagonally and cardinally. The cell itself is not
     * included.
     *
     * @param  x Column of the cell.
     * @param  y Row of the cell.
     * @return   Integer amount of live neighbors.
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
     * Perform a logical update on all cells.
     *
     * If a live cell has two or three neighbors, it will live in the next
     * generation, otherwise it will die. If a dead cell has three neighbors,
     * it will live in the next generation.
     *
     * @param gc    Game container automatically passed by Slick2D.
     * @param delta Milliseconds since this method was previously called.
     * @see         #cellNeighbors(int x, int y)
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
     *
     * @param gc Game container automatically passed by Slick2D.
     * @param g  Game screen graphics context.
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
     *
     * @param args Arguments passed into the program.
     */    
    public static void main(String[] args)
    {
       try {
            AppGameContainer app;
            app = new AppGameContainer(new LittyLife("Litty's Game of Life"));
            app.setDisplayMode(windowWidth, windowHeight, false);
            app.setTargetFrameRate(10);
            app.setShowFPS(false);
            app.start();
        }
        catch (SlickException e) {
            System.out.println("Slick2D Exception: " + e.getMessage());
        }
    }
}
