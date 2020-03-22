/**
 * @author Issa Mathno (mathnoi@spu.edu)
 * @file PersonParser.java
 */
package team.whatever.util;

import team.whatever.community.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonParser {

    private final String DELIMITER = ",";
    private List<Person> people = new ArrayList<>();

    /**
     * This constructor takes a file path and parses the community members names.
     * This detects couple via a comma delimiter.
     *
     * @param filePath the file path to the data file.
     * @throws FileNotFoundException an invalid file path was provided.
     */
    public PersonParser(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner fScanner = new Scanner(file);

        String data;
        while (fScanner.hasNextLine()) {
            data = fScanner.nextLine();
            String[] names = data.split(this.DELIMITER);

            if (names.length == 2) {
                // Adds the first spouse into the array.
                // Then generates the other spouse but not actually add them to the array.
                people.add(new Person(names[0], new Person(names[1])));
            } else if (names.length == 1) {
                // Generate a single person
                people.add(new Person(names[0]));
            } else {
                System.err.println(filePath + ": contains an invalid format at line containing \"" + data + "\"");
            }
        }
    }

    /**
     * A simple getter to get a list of people.
     *
     * @return a list of people in the community
     */
    public List<Person> getPeople() {
        return people;
    }
}
