/**
 * @author Trent Howell (howellt@spu.edu)
 * @author Issa Mathno (mathnoi@spu.edu)
 *
 * @file SaveList.java
 */
package team.whatever.util;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import team.whatever.algorithm.Group;
import team.whatever.community.Person;

public class SaveList 
{
    //Writes the group scheduling created by the groups algorithm to a final text file
    public static void saveGroupings(List<Person> people, int groupSize, String filePath) throws IOException
    {
        int n = 1;
        String saveIt = "";
        Group group = new Group(people, groupSize);
        Graph<List<List<Person>>, DefaultEdge> graph = group.generateGraph();
        
        for (List<List<Person>> p : graph.vertexSet()) {
            saveIt += "Grouping for Week " + n + '\n';
                for (List<Person> a : p) {
                    for (Person b : a) {
                        saveIt += b.getName() + " ";
                    }
                    saveIt += '\n';
                }
            n++;
            saveIt += '\n';
        }
        SaveList.saveToFile(filePath, saveIt);
    }

    /**
     * Save the file to the given path.
     * @param path to the file location.
     * @param text the data being stored in the file.
     * @throws IOException the file probably couldn't be generated
     */
    public static void saveToFile(String path, String text) throws IOException
    {
        FileWriter saveTo = new FileWriter(path, false);
        PrintWriter save = new PrintWriter(saveTo);
        save.printf(text);
        save.close();
    }
}
