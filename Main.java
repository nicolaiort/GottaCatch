
import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;

public class Main 
{

    private JFrame frame;
    private JDialog dialog;
    private JColorChooser colorChooser;
    private JFileChooser fileChooser;
    
    public static void main(String args[])
    {
       new Main();
       new ShowImageExample();
    }
    
    
    public Main()
    {
        
        frame = new JFrame("HAUPTFENSTER");
        frame.setSize(1000,1000);
        frame.getContentPane().setBackground(Color.green);
        frame.setVisible(true);
        frame.add(new JLabel("Beispiel JLabel"));
        frame.setTitle("Pokemon");
        
        //Color ausgewaehlteFarbe = JColorChooser.showDialog(null,"Farbauswahl", null);
        //JColorChooser colorChooser = new JColorChooser();
        //frame.getContentPane().add(colorChooser);
        
        
        
//             setDefaultCloseOperation(EXIT_ON_CLOSE);
//             frame.add(new JLabel(new ImageIcon("c:/desktop.jpg")));
//             pack();
//             setVisible(true);
    }

    
    
     
     
 
//     public ShowImageExample()
//     {
//         super("ShowImageExample");
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         add(new JLabel(new ImageIcon("c:/desktop.jpg")));
//         pack();
//         setVisible(true);
//      }
  
    

}


