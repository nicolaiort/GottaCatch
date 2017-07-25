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
      
      public FooActionListenerZwei (JTextField field, Kampf ka) throws InterruptedException
      {
        this.field = field;
        kampf=ka;
      }
      
      @Override
      public void actionPerformed (ActionEvent eztrewq)
      {
         //System.out.println ("Pressed");
         try{
         kampf.angriffff(Integer.parseInt(field.getText()));
         System.out.println (field.getText() +" wurde ausgewählt");
        }
         catch(InterruptedException eztrewqqwertz){};
      }
   }