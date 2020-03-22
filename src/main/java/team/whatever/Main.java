package team.whatever;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import team.whatever.algorithm.Group;
import team.whatever.community.Person;
import team.whatever.util.PersonParser;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

class Main {

    public static void main(String[] args) throws FileNotFoundException {
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