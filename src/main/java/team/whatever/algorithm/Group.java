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

    private final int GROUP_SIZE = 5;

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
                    for (Person person : this.COMMUNITY) {
                        if (available.get(person)) {
                            if (k == 0) {
                                if (!hasHosted.get(person) && available.get(person)) {
                                    if (person.hasSpouse()) {
                                        group.add(person);
                                        group.add(person.getSpouse());
                                        hasHosted.put(person, Boolean.TRUE);
                                        available.put(person, Boolean.FALSE);
                                        k++;
                                        break;
                                    } else {
                                        group.add(person);
                                        hasHosted.put(person, Boolean.TRUE);
                                        available.put(person, Boolean.FALSE);
                                        break;
                                    }
                                }
                            } else {
                                if (!person.hasSpouse()) {
                                    group.add(person);
                                    available.put(person, Boolean.FALSE);
                                    break;
                                } else if (person.hasSpouse() && k + 2 < GROUP_SIZE) {
                                    group.add(person);
                                    available.put(person, Boolean.FALSE);
                                    group.add(person.getSpouse());
                                    k++;
                                    break;
                                }

                            }
                        }
                    }
                }
                iteration.add(group);
            }

            if (available.containsValue(Boolean.TRUE)) {
                for (Person person : this.COMMUNITY) {
                    if (available.get(person)) {
                        if (person.hasSpouse()) {
                            iteration.get(iteration.size() - 1).add(person);
                            iteration.get(iteration.size() - 1).add(person.getSpouse());
                            available.put(person, Boolean.FALSE);
                        } else {
                            iteration.get(iteration.size() - 1).add(person);
                            available.put(person, Boolean.FALSE);
                        }
                    }
                }
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