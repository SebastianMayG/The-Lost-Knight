import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Dungeon extends World
{

    /**
     * Constructor for objects of class Dungeon.
     * 
     */
    public Dungeon()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        setWalls();
        addObject(new Player(), 400, 460);
        addObject(new HUD(), 73, 31);
    }
    
    public void setWalls()
    {
        //Puerta
        addObject(new Door(), 411, 6);
        
        //Muros superior e inferior
        addObject(new Wall(), 400, 6 ); //Primero se añade el objeto Wall
        getObjects(Wall.class).get(0).getImage().scale(800, 50); //Se ajusta su tamaño
        addObject(new Wall(),400, 599);
        getObjects(Wall.class).get(1).getImage().scale(800, 28);
        
        //Muros laterales
        addObject(new Wall(),34, 300);
        getObjects(Wall.class).get(2).getImage().scale(60, 600);
        addObject(new Wall(),764, 300);
        getObjects(Wall.class).get(3).getImage().scale(60, 600);
        
        //Muro de la puerta inferior
        addObject(new Wall(), 402, 556);
        getObjects(Wall.class).get(4).getImage().scale(150, 60);
        
        addObject(new Sound(), 0, 0);
    }
    
    //Método que sirve para reproducir la música de fondo
    public void playMusic(GreenfootSound music)
    {
        if (!music.isPlaying()) //Si la musica no se está tocando
        {
            music.playLoop(); //Reproducela
        }
    }
}
