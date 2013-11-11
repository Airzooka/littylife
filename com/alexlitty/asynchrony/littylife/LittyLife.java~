package com.alexlitty.asynchrony.littylife;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class LittyLife extends BasicGame
{
    public int pos;

    /**
     * Game constructor.
     */
    public LittyLife(String gamename) {
        super(gamename);
        pos = 0;
    }

    /**
     * 
     */
    @Override
    public void init(GameContainer gc) throws SlickException {
        
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
            app.setDisplayMode(640, 480, false);
            app.start();
        }
        
        catch (SlickException e) {
            System.out.println("Slick2D Exception: " + e.getMessage());
        }
    }
}
