
import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame
{

    private JFrame frame;
    private JDialog dialog;
    private JColorChooser colorChooser;
    private JFileChooser fileChooser;
    
    public static void main(String args[])
    {
       new Main();
       
    }
    
    
    public Main()
    {
        super("ShowImageExample");
        
        frame = new JFrame("HAUPTFENSTER");
        frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.green);
        frame.add(new JLabel("Beispiel JLabel"));
        frame.setTitle("Pokemon");
        JLabel map=new JLabel(new ImageIcon("map.png"));
        frame.add(map);
        map.setLocation(100, 100);
        frame.setVisible(true);
        //Color ausgewaehlteFarbe = JColorChooser.showDialog(null,"Farbauswahl", null);
        //JColorChooser colorChooser = new JColorChooser();
        //frame.getContentPane().add(colorChooser);
        
        
        
//             setDefaultCloseOperation(EXIT_ON_CLOSE);
//             frame.add(new JLabel(new ImageIcon("c:/desktop.jpg")));
//             pack();
//             setVisible(true);
    }

    
    
     
     
 
         // public void ShowImageExample()
         // {
             // super("ShowImageExample");
             // setDefaultCloseOperation(EXIT_ON_CLOSE);
             // add(new JLabel(new ImageIcon("test.png")));
             // pack();
             // setVisible(true);
          // }
  
    

}


