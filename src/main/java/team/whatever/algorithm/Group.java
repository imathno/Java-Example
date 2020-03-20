package team.whatever.algorithm;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import team.whatever.community.Person;

import java.util.List;
import java.util.Map;
import org.jgrapht.Graph;

public class Group {

    private final int GROUP_SIZE = 4;

    private final List<Person> COMMUNITY;
    private int numOfGroups;
    private int iterations;
    private Map<Person, Boolean> hosted;

    public Group(List<Person> community) {
        this.COMMUNITY = community;
        int actualSize = community.size();

        for (int i = 0; i < community.size(); i++) {
            if (community.get(i).hasSpouse())
                actualSize++;
        }

        this.numOfGroups = actualSize / GROUP_SIZE;
        this.iterations = community.size() / this.numOfGroups;
    }

    public Graph<Person, DefaultEdge> generateGraph() {
        Graph<Graph<List<List<Person>>, DefaultUndirectedGraph>, DefaultUndirectedGraph> finalGraph;
        for (int i = 0; i < this.iterations; i++) {
            for (int j = 0; j < this.numOfGroups; j++) {
                
            }
        }
        return null;
    }
}

//    //Initializes the beenVisited array to be the correct size and contain any initial data
//    public void initBeenVisited(int numPeople) {
//        beenVisited = new Person[numPeople];
//
//        if(MARRIED) {
//            unvisited = numPeople - 2;
//            beenVisited[0] = SPOUSE;
//        } else {
//            unvisited = numPeople - 1;
//        }
//    }

//    //Checks if the visitor being looked at has already visited this person's house
//    public boolean alreadyVisited(Person visitor) {
//        List<Person> check = Arrays.asList(beenVisited);
//        return !(check.contains(visitor));
//    }
//
//    //Adds the visitor to the list of people who have visited this person
//    public void visitedBy(Person visitor) {
//        beenVisited[beenVisited.length - unvisited] = visitor;
//        unvisited++;
//    }
