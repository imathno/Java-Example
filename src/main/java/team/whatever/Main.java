/**
 * @author Trent Howell (howellt@spu.edu)
 * @file Main.java
*/

package team.whatever;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import team.whatever.algorithm.Group;
import team.whatever.community.Person;
import team.whatever.util.PersonParser;
import team.whatever.gui.GUI;
import java.io.FileNotFoundException;
import java.util.List;

class Main {

    public static void main(String[] args) throws FileNotFoundException 
    {
        GUI.initiate();
        PersonParser parser = new PersonParser("data/group1.txt");
        Group group = new Group(parser.getPeople());
        Graph<List<List<Person>>, DefaultEdge> graph = group.generateGraph();

        for (List<List<Person>> p : graph.vertexSet()) {
            for (List<Person> a : p) {
                for (Person b : a) {
                    System.out.print(b.getName() + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}