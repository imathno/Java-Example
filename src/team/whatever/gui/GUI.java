//Trent Howell
//Community Small Groups GUI

import javax.swing.*;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener {
    protected JButton Group1, Group2, Group3;
    
    //create our GUI object to hold all of the buttons for interaction
    public GUI()
    {
        //Initialize our first button and its action
        Group1 = new JButton("Run Group 1");
        Group1.setMnemonic(KeyEvent.VK_D);
        Group1.setActionCommand("G1");
        
        //Initialize our second button and its action
        Group2 = new JButton("Run Group 2");
        Group2.setMnemonic(KeyEvent.VK_D);
        Group2.setActionCommand("G2");
        
        //Initialize our third button and its action
        Group3 = new JButton("Run Group 3");
        Group3.setMnemonic(KeyEvent.VK_D);
        Group3.setActionCommand("G3");
        
        //Adds a listener to the buttons to ensure clicking them performs the appropriate task
        Group1.addActionListener(this);
        Group2.addActionListener(this);
        Group3.addActionListener(this);
        
        //Add the buttons to the GUI object
        add(Group1);
        add(Group2);
        add(Group3);
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
    public static void main(String args[])
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