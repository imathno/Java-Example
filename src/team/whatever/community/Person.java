//Trent Howell
//Community Small Groups Person Object
package team.whatever.community;

import java.util.*;

public class Person 
{
   //Initializing the name,spouse, and other important variables
	String name,spouse;
	boolean married;
	String[] beenVisited;	
	int unvisited;
	
   //Constructor for making a new person object
	public Person(String n, String s, boolean m)
	{
        //Sets the value of the name, spouse and makes the beenVisited array the correct size
		name = n;
		spouse = s;
                married = m;	
        }
   
    //Initializes the beenVisited array to be the correct size and contain any initial data
        public void initBeenVisited(int numPeople)
        {
            beenVisited = new String[numPeople];
            
            if(married)
            {
                unvisited = numPeople - 2;
                beenVisited[0] = spouse;
            }
            else
            {
                unvisited = numPeople - 1;
            }
        }
        
   //Returns the spouse of the Person if they exist
	public String getSpouse()
	{
		if (married)
			return spouse;
		else
			return "";
	}
	
   //Returns if the person is married
	public boolean hasSpouse()
	{
		return married;
	}
	
   //Checks if the visitor being looked at has already visited this person's house
	public boolean alreadyVisited(String visitor)
	{
		List<String> check = Arrays.asList(beenVisited);

		if(check.contains(visitor))
			return false;
		else
			return true;
	}
	
   //Adds the visitor to the list of people who have visited this person
	public void visitedBy(String visitor)
	{
		beenVisited[beenVisited.length - unvisited] = visitor;
		unvisited++;
	}
}