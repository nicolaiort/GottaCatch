import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FooActionListener implements ActionListener {
      
      private JTextField field;
      private Kampf kampf;
      private JDialog d1;
      
      public FooActionListener (JTextField field, Kampf ka, JDialog d) throws InterruptedException
      {
        this.field = field;
        kampf=ka;
        d1=d;
      }
      
      @Override
      public void actionPerformed (ActionEvent e)
      {
         //System.out.println ("Pressed");
         try{
         kampf.fighterSetzen(field.getText());
         System.out.println (field.getText() +" wurde ausgewählt");
         d1.dispose();
        }
         catch(InterruptedException qwertz){};
      }
   }