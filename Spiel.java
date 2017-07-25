import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Spiel
{
    private Spieler p;
    private Thread thread1;
    public Spiel(String name)
    {
        p=new Spieler(name,new Pokemon("Pickachu",2,50,10,new Attack(10, "tackle")));
        Map m = new Map(p,thread1);
        p.mapSetzen(m);
        spiele();
        gameloop();
    }
    
        public void spiele()
    {
        Fenster spiel = new Fenster(p);
        spiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spiel.setVisible(true);
        spiel.setFocusable(true);
    }
    
    public void wait(int ms)
    {
        try
        {
            thread1.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            //
        }
    }

    public void gameloop()
    {
        while(p.returnInfight()==false)
        {
            p.refresh();
            wait(100);
            
        }
        
    }
}
