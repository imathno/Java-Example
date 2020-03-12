//Trent Howell
//Community Small Groups GUI
package team.whatever.gui;

import javax.swing.*;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener {
    protected JButton group1, group2, group3;
    
    //create our GUI object to hold all of the buttons for interaction
    public GUI()
    {
        //Initialize our first button and its action
        group1 = new JButton("Run Group 1");
        group1.setMnemonic(KeyEvent.VK_D);
        group1.setActionCommand("G1");
        
        //Initialize our second button and its action
        group2 = new JButton("Run Group 2");
        group2.setMnemonic(KeyEvent.VK_D);
        group2.setActionCommand("G2");
        
        //Initialize our third button and its action
        group3 = new JButton("Run Group 3");
        group3.setMnemonic(KeyEvent.VK_D);
        group3.setActionCommand("G3");
        
        //Adds a listener to the buttons to ensure clicking them performs the appropriate task
        group1.addActionListener(this);
        group2.addActionListener(this);
        group3.addActionListener(this);
        
        //Add the buttons to the GUI object
        add(group1);
        add(group2);
        add(group3);
    }
    
    //Setup the actions of our buttons
    public void actionPerformed(ActionEvent e)
    {
         if ("G1".equals(e.getActionCommand()))
         {
            System.out.println("Group1!");
            //Placeholder code above
            //Once finished with main program then this button will run the graph maker with group1.txt as the input
         }
         
         else if ("G2".equals(e.getActionCommand()))
         {
            System.out.println("Group2!");
            //Placeholder code above
            //Once finished with main program then this button will run the graph maker with group2.txt as the input
         }
         
         else if ("G3".equals(e.getActionCommand()))
         {
            System.out.println("Group3!");
            //Placeholder code above
            //Once finished with main program then this button will run the graph maker with group3.txt as the input
         }
    }
    
    //Initializes the actual GUI with our GUI object
    public static void initiate()
    {
      JFrame frame = new JFrame("Community Small Group - Team Whatever");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        GUI newContentPane = new GUI();
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
   
}