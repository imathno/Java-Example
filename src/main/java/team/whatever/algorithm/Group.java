package team.whatever.algorithm;

import org.jgrapht.graph.DefaultEdge;
import team.whatever.community.Person;

import java.util.Map;
import org.jgrapht.Graph;

public class Group {

    private Person[] community;
    private Map<Person, Boolean> visitedHomes;

    public Group(Person[] community) {
        this.community = community;
    }

    public Graph<Person, DefaultEdge> generateGraph() {
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
