/**
 * @author Issa Mathno (mathnoi@spu.edu)
 * @author Trent Howell (howellt@spu.edu)
 * @file Group.java
 * @description This file contains the algorithm to solve for
 * the community small group problem given in our @course CSC3430.
 */
package team.whatever.algorithm;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import team.whatever.community.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;

public class Group {

    // Constants for the instance of this Group
    private final int GROUP_SIZE;
    private final List<Person> COMMUNITY;

    private int numOfGroups;
    private int iterations;

    /**
     * The constructor does a few calculations and assign the variables values.
     * @param community an array of people in the community. Everyone has a weight
     *                  of 1 while couples have a weight of 2.
     * @param groupSize the size capacity per group
     */
    public Group(List<Person> community, int groupSize) {
        this.COMMUNITY = community;
        this.GROUP_SIZE = groupSize;
        // This is the true size of the community as COMMUNITY doesn't count spouses
        int actualSize = community.size();

        for (Person person : community) {
            if (person.hasSpouse())
                actualSize++;
        }

        // Calculate the number of groups depending on the group size
        this.numOfGroups = actualSize / GROUP_SIZE;
        this.iterations = (int) Math.ceil(community.size() / (double) this.numOfGroups);
    }

    /**
     * A function that generates a graph of the community. The graph represents
     * people going to each others house with a new host each time.
     *
     * @return a graph in which each node represents an iteration that contains
     * numOfGroups per node.
     */
    public Graph<List<List<Person>>, DefaultEdge> generateGraph() {
        Graph<List<List<Person>>, DefaultEdge> generatedGraph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        List<List<List<Person>>> iterationNodes = new ArrayList<>();
        Map<Person, Boolean> hasHosted = new HashMap<>();

        // Fill the hash map with all people from the community and set the host status to false.
        for (int i = 0; i < this.COMMUNITY.size(); i++) {
            hasHosted.put(this.COMMUNITY.get(i), Boolean.FALSE);
        }

        // We will iterate @var iterations times.
        // This means that we will have @var iterations nodes.
        for (int i = 0; i < iterations; i++) {
            List<List<Person>> iteration = new ArrayList<>(); // All the groups in that iteration
            Map<Person, Boolean> available = new HashMap<>();

            // Fill hash map with all the people and set them as available each iteration.
            for (Person value : this.COMMUNITY) {
                available.put(value, Boolean.TRUE);
            }

            for (int j = 0; j < numOfGroups; j++) {
                // An array of the group with the host being at index 0.
                List<Person> group = new ArrayList<>();

                for (int k = 0; k < GROUP_SIZE; k++) {
                    // Finds the next available person / couple to add to the group.
                    for (Person person : this.COMMUNITY) {
                        if (available.get(person)) {
                            // Set the host
                            if (k == 0) {
                                if (!hasHosted.get(person) && available.get(person)) {
                                    // The person has a spouse
                                    if (person.hasSpouse()) {
                                        group.add(person);
                                        group.add(person.getSpouse());
                                        hasHosted.put(person, Boolean.TRUE);
                                        available.put(person, Boolean.FALSE);
                                        k++; // Since there is a spouse the group size increases + 1 making + 2
                                        break; // Stop the search
                                    } else {
                                        group.add(person);
                                        hasHosted.put(person, Boolean.TRUE);
                                        available.put(person, Boolean.FALSE);
                                        break; // Stop the search
                                    }
                                }
                            } else {
                                if (!person.hasSpouse()) {
                                    group.add(person);
                                    available.put(person, Boolean.FALSE);
                                    break; // Stop the search
                                } else if (person.hasSpouse() && k + 2 < GROUP_SIZE) {
                                    // Adding a couple to the group as the group still has the capacity
                                    group.add(person);
                                    available.put(person, Boolean.FALSE);
                                    group.add(person.getSpouse());
                                    k++;
                                    break; // Stop the search
                                }
                            }
                        }
                    }
                }
                iteration.add(group);
            }

            // Append the remaining people to the last group
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

        // Generate the actual graph
        List<List<Person>> prevNode = null;
        for (List<List<Person>> node : iterationNodes) {
            generatedGraph.addVertex(node);
            if (prevNode != null) {
                // Connect the two nodes together
                generatedGraph.addEdge(node, prevNode);
            }
            prevNode = node;
        }
        return generatedGraph;
    }
}