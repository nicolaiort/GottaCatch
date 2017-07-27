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

}
 