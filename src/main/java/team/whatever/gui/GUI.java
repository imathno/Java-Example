//Trent Howell
//Community Small Groups GUI
package team.whatever.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI extends JPanel implements ActionListener {
    protected JButton group1, group2, group3;
    protected JComboBox groupSize;
    public int theGroupSize;
    
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
        
        //Initialize the selection for group size
        String[] sizeOptions = {"3 People per group","4 People per group","5 People per group","6 People per group"};
        groupSize = new JComboBox(sizeOptions);
        groupSize.setSelectedIndex(1);
        theGroupSize = 4;
        
        //Adds a listener to the GUI elements to ensure interacting with them performs the appropriate task
        group1.addActionListener(this);
        group2.addActionListener(this);
        group3.addActionListener(this);
        groupSize.addActionListener(this);
        
        //Add the buttons and selection box to the GUI object
        add(group1);
        add(group2);
        add(group3);
        add(groupSize);
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
         
         //Handles if the group size is updated
         JComboBox update = (JComboBox)e.getSource();
         if (update != null)
         {
             if(update.getSelectedIndex() == 0)
             {
                 theGroupSize = 3;
             }
             else if (update.getSelectedIndex() == 1)
             {
                 theGroupSize = 4;
             }
             else if (update.getSelectedIndex() == 2)
             {
                 theGroupSize = 5;
             }
             else if (update.getSelectedIndex() == 3)
             {
                 theGroupSize = 6;
             }
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