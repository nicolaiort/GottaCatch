

public class Ball extends Item
{
    private int stärke;
    private String name;
    private int Anzahl;
    public Ball(int s, String n, int a)
    {
        stärke = s;
        name = n;
        Anzahl = a;
        
    }
    
    public int staerkeGeben()
    {
     return stärke;
    }
    
    public void gibName()
    {
        System.out.println(name);
    }

    public void senke()
    {
        Anzahl = Anzahl-1;
    }
    
    public void erhoeheAnzahl()
    {
        Anzahl = Anzahl + 1;
    }
    
    public void givestats()
    {
        System.out.println(Anzahl + "-mal " + name);
    }
}
