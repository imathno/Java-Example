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
    private List<Person> people = new ArrayList<Person>();

    /**
     * This constructor takes a file path and parses the community members names.
     * This detects couple via a comma delimiter.
     * @param filePath the file path to the data file.
     * @throws FileNotFoundException probably gave it a bad file name.
     */
    public PersonParser(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner fScanner = new Scanner(file);

        String data;
        int i = 0;
        while (fScanner.hasNextLine()) {
            data = fScanner.nextLine();
            String[] names = data.split(this.DELIMITER);

            if (names.length != 1) {
                // Generate two people
                people.add(new Person(names[0], new Person(names[1])));
                people.add(people.get(i));
                i += 2;
            } else {
                // Generate one person
                people.add(new Person(names[0]));
                i++;
            }
        }
    }

    public List<Person> getPeople() {
        return people;
    }
}