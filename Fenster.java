import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenster extends JFrame
{
    
    private Spieler p;
    public Fenster(Spieler s) 
    {
        super();
        p=s;

        // Fenstertitel (das was oben am Programm steht)
        setTitle("Pokemon");

        // das Fenster ist nicht in der Groesse veraenderbar
        setResizable(false);

        setBackground(Color.white);
        
        //Groesse des Fensters
        setSize(new Dimension(500,500));
        JLabel map=new JLabel(new ImageIcon("map.png"));
        add(map);
        JLabel icn=new JLabel(new ImageIcon("playericon.png"));
        add(icn);
        icn.setPreferredSize(new Dimension(5, 5)); 
        icn.setLocation(100, 100);
        
        
        addKeyListener(new KeyAdapter()
            {

                public void keyPressed(KeyEvent evt) // bei Tastendruck
                {  
                    if (evt.getKeyCode() == KeyEvent.VK_RIGHT)
                    {
                        p.nachRechts(true);
                        repaint();
                    }

                    if (evt.getKeyCode() == KeyEvent.VK_LEFT )
                    {
                        p.nachLinks(true);
                        repaint();
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_UP )
                    {
                        p.nachOben(true);
                        repaint();
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_DOWN )
                    {
                        p.nachUnten(true);
                        repaint();
                    }
                }

                public void keyReleased(KeyEvent evt) // bei Loslassen
                {                
                    if (evt.getKeyCode() ==KeyEvent.VK_RIGHT)
                    {
                        p.nachRechts(false);
                        repaint();
                    }

                    if (evt.getKeyCode() == KeyEvent.VK_LEFT )
                    {
                        p.nachLinks(false);
                        repaint();
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_UP )
                    {
                        p.nachOben(false);
                        repaint();
                    }
                    
                    if (evt.getKeyCode() == KeyEvent.VK_DOWN )
                    {
                        p.nachUnten(false);
                        repaint();
                    }
                }
            });
    }
}
