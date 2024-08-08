import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainForest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainForest extends Forest
{

    /**
     * Constructor for objects of class MainForest.
     * 
     */
    public MainForest()
    {
        setWalls();
        addObject(new Player(0), 400, 217);
        addObject(new Transition(), 400, 300);
        addObject(new Sound(), 0, 0);
    }
    
    //El segundo constructor ayuda para cuando el jugador viene desde arriba
    public MainForest(int x)
    {
        setWalls();
        addObject(new Player(), 400, 80);
        addObject(new Sound(), 0, 0);
    }
    
    public void setWalls()
    {
        addObject(new Wall(), 73, 300);
        getObjects(Wall.class).get(0).getImage().scale(200, 800);
        addObject(new Wall(), 728, 300);
        getObjects(Wall.class).get(1).getImage().scale(200, 800);
        addObject(new Wall(), 400, 449);
        getObjects(Wall.class).get(2).getImage().scale(800, 300);
        
        addObject(new Teleporter(), 400, 10);
        getObjects(Teleporter.class).get(0).getImage().scale(448, 20);
    }
}
