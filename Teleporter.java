import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//La manera en la que funciona es la siguiente:
//Al momento de ser creado, almacena el nombre del lugar en el que está
//Dependiendo de ese nombre, el lugar de destino cambia, en pocas palabras
//Nuestros escenarios ya están predefinidos

public class Teleporter extends Others
{
    protected String currentZone;
    public Teleporter()
    {
        
    }
    
    public void act()
    {
        currentZone = getWorld().getClass().getName();
        teleport();
    }
    
    public void teleport()
    {
        if(isTouching(Player.class) )
        {
            switch(currentZone)
            {
                case "Path":
                    if(getY() < 200 && Player.folderName != "normal")
                    {
                        Greenfoot.setWorld(new Dungeon1());
                    }
                    break;
                case "Dungeon1":
                    Player.levelsCleared++;
                    Greenfoot.setWorld(new Dungeon2());
                    break;
                case "Dungeon2":
                    Player.levelsCleared++;
                    Greenfoot.setWorld(new Dungeon3());
                    break;
                case "Dungeon3":
                    Player.levelsCleared++;
                    Greenfoot.setWorld(new DungeonRandom());
                    break;
                case "DungeonRandom":
                    Player.levelsCleared++;
                    if(Player.levelsCleared % 10 == 0)
                    {
                        Greenfoot.setWorld(new DungeonBoss());
                    }
                    else
                    {
                        Greenfoot.setWorld(new DungeonRandom());
                    }
                    break;
                case "DungeonBoss":
                    Player.levelsCleared++;
                    Greenfoot.setWorld(new DungeonRandom());
                    break;
            }            
        }

        if(currentZone == "Path" || currentZone == "MainForest")
        {
            if(isTouching(Player.class))
            {
                switch(currentZone)
                {
                    case "MainForest": //Vamos a distingir cuando el jugador agarre la espada oxidada
                        if(Player.folderName == "normal")
                        {
                            Greenfoot.setWorld(new Path());
                        }
                        else
                        {
                            Greenfoot.setWorld(new Path(0)); //Ahora la espada ya no estará
                        }
                        break;
                    case "Path":
                        if(getY()> 400) //Significa que el teleport es el de abajo
                        {
                            Greenfoot.setWorld(new MainForest(0));
                            break;                            
                        }

                }
            }
        }
    }
    
}
