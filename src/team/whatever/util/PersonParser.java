/**
 * @Author Issa Mathno (mathnoi@spu.edu)
 * @Class PersonParser.java
 */
package team.whatever.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonParser {

    private final String DELIMITER = ",";

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
        while (fScanner.hasNextLine()) {
            data = fScanner.nextLine();
            String[] people = data.split(this.DELIMITER);

            if (people.length != 1) {
                // Generate two people
            } else {
                // Generate one person
            }
        }
    }
}
