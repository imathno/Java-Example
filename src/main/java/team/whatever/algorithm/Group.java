package team.whatever.algorithm;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import team.whatever.community.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jgrapht.Graph;

public class Group {

    private final int GROUP_SIZE = 2;

    private final List<Person> COMMUNITY;
    private int numOfGroups;
    private int iterations;
    private List<Person> notHosted;

    public Group(List<Person> community) {
        this.COMMUNITY = community;
        int actualSize = community.size();

        for (int i = 0; i < community.size(); i++) {
            if (community.get(i).hasSpouse())
                actualSize++;
        }

        this.numOfGroups = actualSize / GROUP_SIZE;
        this.iterations = (int) Math.ceil(community.size() / (double) this.numOfGroups);
    }

    public Graph<List<List<Person>>, DefaultEdge> generateGraph() {
        Graph<List<List<Person>>, DefaultEdge> finalGraph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        List<List<List<Person>>> addMeToFinal = new ArrayList<>();
        this.notHosted = new ArrayList<>(COMMUNITY);
        for (int i = 0; i < this.iterations; i++) {
            List<List<Person>> iterationList = new ArrayList<>();
            Map<String, Boolean> visiting = new HashMap<>();
            if (notHosted.size() == 1) {
                notHosted.add(COMMUNITY.get(0));
            }
            for (int j = 0; j < this.numOfGroups; j++) {
                List<Person> groupList = new ArrayList<>();
                groupList.add(0, notHosted.get(0));
                visiting.put(groupList.get(0).getName(), Boolean.TRUE);
                notHosted.remove(0);

                for (int k = 1; k < this.GROUP_SIZE; k++) {
                    for (Person person : this.COMMUNITY) {
                        // Checks if the person is the host or is already visiting
                        if (!visiting.containsKey(person.getName())) {
                            groupList.add(person);
                            visiting.put(person.getName(), Boolean.TRUE);
                            break;
                        }
                    }
                }

                if (visiting.size() != this.numOfGroups) {
                    for (Person person : this.COMMUNITY) {
                        // Checks if the person is the host or is already visiting
                        if (!visiting.containsKey(person.getName())) {
                            groupList.add(person);
                            visiting.put(person.getName(), Boolean.TRUE);
                            break;
                        }
                    }
                }
                iterationList.add(groupList);
            }
            addMeToFinal.add(iterationList);
        }

        List<List<Person>> previousAdd = new ArrayList<List<Person>>();
        for (List<List<Person>> add : addMeToFinal) {
//            if (previousAdd == null) {
//                finalGraph.addVertex();
//            } else {
//                finalGraph.addVertex(add);
//                finalGraph.addEdge(add, previousAdd);
//            }
//            previousAdd = add;
            for (List<Person> p : add) {
                for (Person a : p) {
                    System.out.print(a.getName() + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return null;
    }
}