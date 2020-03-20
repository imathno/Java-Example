/**
 * @author Trent Howell (howellt@spu.edu)
 * @author Issa Mathno (mathnoi@spu.edu)
 * @file Person.java
 */
package team.whatever.community;

public class Person {

	//Initializing the name,spouse, and other important variables
	private final String NAME;
	private final Person SPOUSE;
	private final boolean MARRIED;
	int unvisited;

	/**
	 * Just a simple constructor for the Person object
	 * @param name of the person
	 * @param spouse a person object of their spouse
	 */
	public Person(String name, Person spouse) {
		this.NAME = name;
		this.SPOUSE = spouse;
		this.MARRIED = spouse != null;
	}

	/**
	 * Just a constructor for the single people
	 * @param name of the person
	 */
	public Person(String name) {
		this(name, null);
	}
        
        /**
         * Get the name of the person
         * thought this was necessary since name is a private member 
         * with currently no method of accessing
         * @return the name string
         */
        public String getName()
        {
                return NAME;
        }
	/**
	 * Get the spouse of the person
	 * @return the spouse person object or null
	 */
	public Person getSpouse() {
		return SPOUSE;
	}
	
   //Returns if the person is married
	public boolean hasSpouse() {
		return MARRIED;
	}
}