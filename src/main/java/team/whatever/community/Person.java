/**
 * @author Trent Howell (howellt@spu.edu)
 * @author Issa Mathno (mathnoi@spu.edu)
 * @file Person.java
 */
package team.whatever.community;

import java.util.Objects;

public class Person {

    // Constants that are unique to the Person.
    private final String NAME;
    private final Person SPOUSE;
    private final boolean MARRIED;

    /**
     * Just a simple constructor for the Person object
     *
     * @param name   of the person
     * @param spouse a person object of their spouse
     */
    public Person(String name, Person spouse) {
        this.NAME = name;
        this.SPOUSE = spouse;
        this.MARRIED = spouse != null;
    }

    /**
     * Just a constructor for the single people
     *
     * @param name of the person
     */
    public Person(String name) {
        this(name, null);
    }

    public String getName() {
        return this.NAME;
    }

    public Person getSpouse() {
        return SPOUSE;
    }

    public boolean hasSpouse() {
        return MARRIED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(NAME, person.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME);
    }
}