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
        Graph <List<List<Person>>, DefaultEdge> generatedGraph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        List<List<List<Person>>> iterationNodes = new ArrayList<>();
        Map<Person, Boolean> hasHosted = new HashMap<>();

        // Fill the map with all people
        for (int i = 0; i < this.COMMUNITY.size(); i++) {
            hasHosted.put(this.COMMUNITY.get(i), Boolean.FALSE);
        }

        for (int i = 0; i < iterations; i++) {
            List<List<Person>> iteration = new ArrayList<>();
            Map<Person, Boolean> available = new HashMap<>();

            for (int j = 0; j < this.COMMUNITY.size(); j++) {
                available.put(this.COMMUNITY.get(j), Boolean.TRUE);
            }

            for (int j = 0; j < numOfGroups; j++) {
                List<Person> group = new ArrayList<>();

                for (int k = 0; k < GROUP_SIZE; k++) {
                    if (k == 0) {
                        for (int l = 0; l < this.COMMUNITY.size(); l++) {
                            if (!hasHosted.get(this.COMMUNITY.get(l)) && available.get(this.COMMUNITY.get(l))) {
                                group.add(this.COMMUNITY.get(l));
                                hasHosted.put(this.COMMUNITY.get(l), Boolean.TRUE);
                                available.put(this.COMMUNITY.get(l), Boolean.FALSE);
                                break;
                            }
                        }
                    } else {
                        for (int l = 0; l < this.COMMUNITY.size(); l++) {
                            if (available.get(this.COMMUNITY.get(l))) {
                                group.add(this.COMMUNITY.get(l));
                                available.put(this.COMMUNITY.get(l), Boolean.FALSE);
                                break;
                            }
                        }
                    }
                }

                if (j == numOfGroups - 1 && available.containsValue(Boolean.TRUE)) {
                    for (Person person : this.COMMUNITY) {
                        if (available.get(person)) {
                            group.add(person);
                            available.put(person, Boolean.FALSE);
                        }
                    }
                }

                iteration.add(group);
            }
            iterationNodes.add(iteration);
        }

        for (List<List<Person>> lp : iterationNodes) {
            for (List<Person> p : lp) {
                for (Person po : p) {
                    System.out.print(po.getName() + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return null;
    }
}

//    Graph<List<List<Person>>, DefaultEdge> finalGraph = new DefaultUndirectedGraph<>(DefaultEdge.class);
//    List<List<List<Person>>> addMeToFinal = new ArrayList<>();
//        this.notHosted = new ArrayList<>(COMMUNITY);
//
//        for (int i = 0; i < this.iterations; i++) {
//        List<List<Person>> iterationList = new ArrayList<>();
//        Map<String, Boolean> visiting = new HashMap<>();
//
//        for (int j = 0; j < COMMUNITY.size(); j++) {
//        visiting.put(COMMUNITY.get(j).getName(), Boolean.FALSE);
//        }
//
//        if (notHosted.size() == 1) {
//        notHosted.add(COMMUNITY.get(0));
//        }
//        for (int j = 0; j < this.numOfGroups; j++) {
//        List<Person> groupList = new ArrayList<>();
//        groupList.add(0, notHosted.get(0));
//        visiting.put(groupList.get(0).getName(), Boolean.TRUE);
//        notHosted.remove(0);
//
//        for (int k = 1; k < this.GROUP_SIZE; k++) {
//        for (Person person : this.COMMUNITY) {
//        // Checks if the person is the host or is already visiting
//        if (!visiting.get(person.getName())) {
//        groupList.add(person);
//        visiting.put(person.getName(), Boolean.TRUE);
//        break;
//        }
//        }
//        }
//
//        if (visiting.containsValue(Boolean.FALSE)) {
//        for (Person person : this.COMMUNITY) {
//        // Checks if the person is the host or is already visiting
//        if (!visiting.get(person.getName())) {
//        groupList.add(person);
//        visiting.put(person.getName(), Boolean.TRUE);
//        break;
//        }
//        }
//        }
//        iterationList.add(groupList);
//        }
//        addMeToFinal.add(iterationList);
//        }
//
//        List<List<Person>> previousAdd = new ArrayList<List<Person>>();
//        for (List<List<Person>> add : addMeToFinal) {
////            if (previousAdd == null) {
////                finalGraph.addVertex();
////            } else {
////                finalGraph.addVertex(add);
////                finalGraph.addEdge(add, previousAdd);
////            }
////            previousAdd = add;
//        for (List<Person> p : add) {
//        for (Person a : p) {
//        System.out.print(a.getName() + " ");
//        }
//        System.out.println();
//        }
//        System.out.println();
//        }
//        return null;