package com.alexlitty.asynchrony.littylife;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import org.newdawn.slick.geom.Rectangle;

class Cell extends Rectangle
{
    private boolean alive;
    
    /**
     * Cell constructor.
     *
     * Prepares this cell's shape, color and state of life.
     */
    public Cell(int x, int y, int w, int h, boolean startAlive) {
        super(x, y, w, h);
        setAlive(startAlive);
    }
    
    /**
     * Returns whether this cell is currently alive.
     *
     * True if alive, false if dead.
     */
    public boolean isAlive() {
        return alive;
    }
    
    /**
     * Sets whether this cell is currently alive.
     *
     * True if alive, false if dead.
     */
    public void setAlive(boolean newAlive) {
        alive = newAlive;
    }
}

public class LittyLife extends BasicGame
{
    public int pos;

    /**
     * Game constructor.
     */
    public LittyLife(String gamename) {
        super(gamename);
    }

    /**
     * 
     */
    @Override
    public void init(GameContainer gc) throws SlickException {
        pos = 0;
    }

    /**
     * Perform an update on the current game logic.
     */
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        
    }

    /**
     * Graphically render the current state of the game.
     */
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawString("Howdy!", pos, pos++);
    }

    /**
     * Litty's Game of Life entry function.
     */    
    public static void main(String[] args)
    {
        try {
            AppGameContainer app;
            app = new AppGameContainer(new LittyLife("Litty's Game of Life"));
            app.setDisplayMode(600, 600, false);
            app.start();
        }
        
        catch (SlickException e) {
            System.out.println("Slick2D Exception: " + e.getMessage());
        }
    }
}
