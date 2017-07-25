
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
// 
// public class ShowImageExample extends JFrame
// {
//     public ShowImageExample()
//     {
//         super("ShowImageExample");
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         add(new JLabel(new ImageIcon("c:/desktop.jpg")));
//         pack();
//         setVisible(true);
//     }
// 
//     public static void main(String[] args) 
//     {
//         new ShowImageExample();
//     }
// }
public class ShowImageExample extends JFrame
{
 
    private JFrame frame;
    public ShowImageExample()
    {
        super("ShowImageExample");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new JLabel(new ImageIcon("test.png")));
        pack();
        setVisible(true);

//          frame = new JFrame("BAUMFENSTER");
//         frame.setSize(100,100);
//         frame.setVisible(true);

        
    }
   
    public static void Main(String[] args) 
    {
         new ShowImageExample();
    }
}