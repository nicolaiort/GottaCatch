import javax.swing.*;
import java.awt.*;

class PicturePanel extends JPanel {
   private Image image;
   private Spieler p;
   PicturePanel(Image image, Spieler s) {
      this.image = image;
      p=s;
   }

    @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if(image != null) {
         g.drawImage(image, 0, 0, this);
      }
      g.drawRect(p.gibX()*5,p.gibY()*5,5,5);
   }
   
   // public void paintplayer(Graphics g)
   // {
       // super.paintComponent(g);
       // g.drawRect(0,0,5,5);
   // }
    // public static void main(String[] args) {
        // JFrame frame = new JFrame("Test1");
        // Image img = null;
        // String imgPfad = "map.png"; //edited
        // Toolkit toolkit = Toolkit.getDefaultToolkit();
        // img = toolkit.getImage(imgPfad);
        // frame.getContentPane().add(new PicturePanel(img));
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(500, 500);
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
    // }
}
 