import greenfoot.*;
public class GameOver extends World
{
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        addObject(new Sound(), 0, 0);
    }

    public void act()
    {
        showText("Salas superadas: " +Player.levelsCleared ,400,500);
        showText("Presiona ENTER para reiniciar",400,550);
        VolverAJugar();
    }
    public void VolverAJugar()
    {
        if(Greenfoot.isKeyDown("ENTER"))
        {
            Greenfoot.setWorld(new MainForest());
        }
    }
}

