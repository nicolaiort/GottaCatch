import javax.swing.*;
import java.awt.*;

class PicturePanel extends JPanel {
   private Image image;

   PicturePanel(Image image) {
      this.image = image;
   }

    @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if(image != null) {
         g.drawImage(image, 0, 0, this);
      }
   }
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
 