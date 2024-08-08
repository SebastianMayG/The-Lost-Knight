import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Path extends Forest
{
    public Path()
    {
        setWalls();
        addObject(new Player(), 400, 470);
        addObject(new RustySword(), 222, 235);
        addObject(new Sound(), 0, 0);
    }
    //El segundo constructor sirve para distinguir de cuando el jugador agarra la
    //espada, y de esta manera no volver a generarla
    public Path(int x)
    {
        setWalls();
        addObject(new Player(), 400, 470);
        addObject(new Sound(), 0, 0);
    }
    
    public void setWalls()
    {
        addObject(new Wall(), 656, 445);
        getObjects(Wall.class).get(0).getImage().scale(287, 326);
        addObject(new Wall(), 138, 512);
        getObjects(Wall.class).get(1).getImage().scale(287, 326);
        addObject(new Wall(), 141, 14);
        getObjects(Wall.class).get(2).getImage().scale(287, 220);
        addObject(new Wall(), 662, 18);
        getObjects(Wall.class).get(3).getImage().scale(287, 326);
        addObject(new Wall(), 792, 236);
        addObject(new Wall(), 27, 250);
        getObjects(Wall.class).get(5).getImage().scale(200, 400); 
        addObject(new Wall(), 400, 5);
        getObjects(Wall.class).get(6).getImage().scale(400, 40);
        
        addObject(new Teleporter(), 400, 47);
        addObject(new Teleporter(), 400, 790);
        getObjects(Teleporter.class).get(1).getImage().scale(300, 40);
        addObject(new Pedestal(), 217, 279);
    }
    
}
