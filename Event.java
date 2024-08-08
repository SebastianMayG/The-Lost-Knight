import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Event extends Others
{
    //Esta clase contiene eventos puntuales predefinidos, como por ejemplo, que en la sala
    //3 salgan unos cofres específicos
    private String currentZone;
    private boolean isLevelCompleted;
    private boolean finished;
    
    public void act()
    {
        currentZone = getWorld().getClass().getName();
        event();
    }
    
    public void event()
    {
        switch(currentZone)
        {
            case "Dungeon3":
            if(finished == false)
            {
                if(isLevelCompleted == false)
                {
                    ArrayList <Enemy> EnemyList = new ArrayList<Enemy>(getWorld().getObjects(Enemy.class));
                    if (EnemyList.size() == 0) //El método size es de la librería ArrayList
                    {
                    isLevelCompleted = true;
                    }
                }
                if(isLevelCompleted == true)
                {
                    getWorld().addObject(new Chest("Katana"), 247, 245);
                    getWorld().addObject(new Chest("Staff"), 533, 245);
                    finished = true;
                }
            }
            if(finished == true)
            {
                getWorld().removeObject(this);
            }

                break;
        }
    }
}
