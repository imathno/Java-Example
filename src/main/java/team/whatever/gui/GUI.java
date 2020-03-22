/**
 * @author Trent Howell (howellt@spu.edu)
 * @file GUI.java
*/
package team.whatever.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import team.whatever.util.PersonParser;
import team.whatever.community.Person;
import java.util.List;


public class GUI extends JPanel implements ActionListener {
    protected JButton group1, group2, group3, custom;
    protected JComboBox groupSize;
    protected JTextField customGroup;
    private String path;
    public int theGroupSize;
    
    //create our GUI object to hold all of the buttons for interaction
    public GUI()
    {
        path = System.getProperty("user.dir");
        
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
        
        //Intialize the custome group button, its text field, and its action
        custom = new JButton("Run Custom Group");
        custom.setMnemonic(KeyEvent.VK_D);
        custom.setActionCommand("CG");
        customGroup = new JTextField(30);
        
        //Initialize the selection for group size
        String[] sizeOptions = {"3 People per group","4 People per group","5 People per group","6 People per group"};
        groupSize = new JComboBox(sizeOptions);
        groupSize.setSelectedIndex(1);
        theGroupSize = 4;
        
        //Adds a listener to the GUI elements to ensure interacting with them performs the appropriate task
        group1.addActionListener(this);
        group2.addActionListener(this);
        group3.addActionListener(this);
        custom.addActionListener(this);
        groupSize.addActionListener(this);
        
        //Add the buttons and selection box to the GUI object
        add(group1);
        add(group2);
        add(group3);
        add(groupSize);
        add(custom);
        add(customGroup);
    }
    
    //Setup the actions of our buttons
    public void actionPerformed(ActionEvent e)
    {
         if ("G1".equals(e.getActionCommand()))
         {
            try
            {
                PersonParser ourPeople = new PersonParser(path + "\\data\\group1.txt");
                List<Person> people = ourPeople.getPeople();
                //then run the group algorithm with the list people
            }
        
            catch (FileNotFoundException ex)  
            {
                //pops up an error message if the file isn't found
                JOptionPane.showMessageDialog(null, "File not found!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
         }
         
         else if ("G2".equals(e.getActionCommand()))
         {
            try
            {
                PersonParser ourPeople = new PersonParser(path + "\\data\\group2.txt");
                List<Person> people = ourPeople.getPeople();
                //then run the group algorithm with the list people
            }
        
            catch (FileNotFoundException ex)  
            {
                //pops up an error message if the file isn't found
                JOptionPane.showMessageDialog(null, "File not found!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
         }
         
         else if ("G3".equals(e.getActionCommand()))
         {
            try
            {
            PersonParser ourPeople = new PersonParser(path + "\\data\\group3.txt");
            List<Person> people = ourPeople.getPeople();
            //then run the group algorithm with the list people
            }
        
            catch (FileNotFoundException ex)  
            {
                //pops up an error message if the file isn't found
                JOptionPane.showMessageDialog(null, "File not found!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
         }
         else if ("CG".equals(e.getActionCommand()))
         {
            try
            {
            PersonParser ourPeople = new PersonParser(path + "\\data\\" + customGroup.getText());
            List<Person> people = ourPeople.getPeople();
            //then run the group algorithm with the list people
            }
        
            catch (FileNotFoundException ex)  
            {
                //pops up an error message if the file isn't found
                JOptionPane.showMessageDialog(null, "File not found!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
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