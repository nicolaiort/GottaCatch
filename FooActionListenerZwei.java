import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FooActionListenerZwei implements ActionListener {
      
      private JTextField field;
      private Kampf kampf;
      private JDialog d1;
      
      public FooActionListenerZwei (JTextField field, Kampf ka, JDialog d) throws InterruptedException
      {
        this.field = field;
        kampf=ka;
        d1=d;
      }
      
      @Override
      public void actionPerformed (ActionEvent eztrewq)
      {
         //System.out.println ("Pressed");
         try
         {
         System.out.println (field.getText() +" wurde ausgewählt");
         kampf.angriffff(Integer.parseInt(field.getText()));
         d1.dispose();
        }
         catch(InterruptedException eztrewqqwertz){};
      }
   }