import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Sound extends Actor
{
    public static GreenfootSound songs[] =
    {
        new GreenfootSound("forest.wav"),       //0
        new GreenfootSound("dungeon.wav"),      //1
        new GreenfootSound("boss.wav"),         //2
        new GreenfootSound("gameOver.wav")      //3
        
    };
    
    public static GreenfootSound sounds[] =
    {
        new GreenfootSound("weaponGot.wav"),     //0
        new GreenfootSound("slash.wav"),         //1
        new GreenfootSound("orb.wav"),           //2
        new GreenfootSound("chest.wav"),         //3
        new GreenfootSound("lowHP.wav"),         //4
        new GreenfootSound("fireball.wav"),      //5
        new GreenfootSound("enemyDefeated.wav"), //6
        new GreenfootSound("orbP.wav"),          //7
        new GreenfootSound("walk.wav"),          //8
        new GreenfootSound("heart.wav")          //9
        
    };
    
    static GreenfootSound worldMusic;
    //Ayuda a mantenr un control de la música de fondo entre mundos
    private int volumeMusic = 30; //Nos sirve para modificar el volumen de la musica
    private int volumeSounds = 80;//Modifica el volumen de los sonidos
    
    public void act()
    {
        //Primero le seteamos el volumen preferido a las canciones y sonidos
        for(int i = 0; i < songs.length; i++)
            songs[i].setVolume(volumeMusic);
        for(int i = 0; i < sounds.length; i++)
            sounds[i].setVolume(volumeSounds);  
        if(worldMusic != null)
            worldMusic.setVolume(volumeMusic);
        
        playMusic();
    }
    
    //Reproduce la música dependiendo del mundo en el que esté
    public void playMusic()
    {
        String world = getWorld().getClass().getName();
        switch (world)
        {
            case "MainForest" : worldMusic = songs[0];
                break;
            case "Path" : worldMusic = songs[0];
                break;
            case "DungeonRandom": worldMusic = songs[1];
                break;
            case "Dungeon1": worldMusic = songs[1];
                break;
            case "Dungeon2": worldMusic = songs[1];
                break;
            case "Dungeon3": worldMusic = songs[1];
                break;
            case "DungeonBoss": worldMusic = songs[2];
                break;
            case "GameOver": worldMusic = songs[3];
                break;
            default : worldMusic = null;
        }
        
        //Si ninguna canción está sonando
        if(worldMusic !=null && !worldMusic.isPlaying() )
        {
            stopMusic();
            worldMusic.play();
        }
    }
    
    //Detiene todas las canciones, para no tener que estar preguntando
    //una por una si se está reproduciendo y luego pararlas manualmente
    public void stopMusic()
    {
        for(int i= 0; i < songs.length; i++)
            songs[i].stop();
    }
}
