import java.awt.*;
import java.applet.*;
 
public class PictureApplet extends Applet {
   private Image image;
 
   public void init() {
      image = getImage(getCodeBase(),"pokemon.png");
   }
 
   public void paint(Graphics g) {
      super.paint(g);
      if(image != null) {
         g.drawImage(image, 0, 0, this);
      }
   }
}