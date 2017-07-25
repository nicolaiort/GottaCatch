import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
public class Fenster extends JFrame
{
    
    private Spieler p;
    public Fenster(Spieler s) 
    {
        super();
        p=s;

        // Fenstertitel (das was oben am Programm steht)
        setTitle("Test");

        // das Fenster ist nicht in der Groesse veraenderbar
        setResizable(false);

        setBackground(Color.white);
        
        //Groesse des Fensters
        setSize(new Dimension(500,500));

        addKeyListener(new KeyAdapter()
            {

                public void keyPressed(KeyEvent evt) // bei Tastendruck
                {  
                    if (evt.getKeyCode() == KeyEvent.VK_RIGHT)
                    {
                        p.nachRechts(true);
                    }

                    if (evt.getKeyCode() == KeyEvent.VK_LEFT )
                    {
                        p.nachLinks(true);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_UP )
                    {
                        p.nachOben(true);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_DOWN )
                    {
                        p.nachUnten(true);
                    }
                }

                public void keyReleased(KeyEvent evt) // bei Loslassen
                {                
                    if (evt.getKeyCode() ==KeyEvent.VK_RIGHT)
                    {
                        p.nachRechts(false);
                    }

                    if (evt.getKeyCode() == KeyEvent.VK_LEFT )
                    {
                        p.nachLinks(false);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_UP )
                    {
                        p.nachOben(false);
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_DOWN )
                    {
                        p.nachUnten(false);
                    }
                }
            });
    }
}
