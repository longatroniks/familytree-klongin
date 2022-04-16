package com.versoaltima;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used for accepting a particular
 * list of inputs which follow the formatting of:
 * "child parent"
 * and then creating a family tree from it.
 */
public class FamilyTree {

    private Map<String, Person> personMap;
    private int numOfRecursions;

    /**
     * Constructor.
     * 
     * @param relationships - list of relationships
     */
    public FamilyTree(List<String> relationships) {
        personMap = new HashMap<String, Person>();
        for (String relationship : relationships) {
            String[] relationshipArray = relationship.split(" ");
            String parent = relationshipArray[1];
            String child = relationshipArray[0];

            if (!personMap.containsKey(parent)) {
                personMap.put(parent, new Person(parent));
            }
            if (!personMap.containsKey(child)) {
                personMap.put(child, new Person(child));
            }
            personMap.get(parent).addChild(personMap.get(child));
            personMap.get(child).addParent(personMap.get(parent));
        }
    }

    /**
     * Print the person who has no parents first,
     * then print the children of the person who has no parents,
     * and keep printing children recursively.
     */
    public void printTree() {
        String indent = "";
        System.out.println("\nFamily Tree : ");
        for (Person person : personMap.values()) {
            if (person.getParents().size() == 0) {
                indent = "";
                System.out.println(person.getName());
                printChildren(indent + "\t", person);
            }
        }
    }

    /**
     * Print the children of the person recursively.
     * 
     * @param indent - indentation
     * @param person - person
     */
    public void printChildren(String indent, Person person) {
        for (Person child : person.getChildren()) {
            numOfRecursions++;
            System.out.println(indent + child.getName());
            printChildren(indent + "\t", child);
        }
    }

    public int getNumOfRecursions() {
        return numOfRecursions;
    }

    /**
     * Returns the map of all people mentioned
     * inside of the relationship list.
     * 
     * @return person map
     */
    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    /**
     * Inner class for easier access to the person's
     * parents and children.
     */
    class Person {
        private String name;
        private List<Person> parents;
        private List<Person> children;

        /**
         * Constructor.
         * 
         * @param name - name of person
         */
        Person(String name) {
            this.name = name;
            this.parents = new ArrayList<>();
            this.children = new ArrayList<>();
        }

        /**
         * Get the name of the person.
         * 
         * @return name - name of person
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name of the person.
         * 
         * @return parents - parents of person
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get the list of parents of the person.
         * 
         * @return parents - parents of person
         */
        public ArrayList<Person> getParents() {
            return (ArrayList<Person>) parents;
        }

        /**
         * Set the list of parents of the person.
         * 
         * @return parents - parents of person
         */
        public void setParents(ArrayList<Person> parents) {
            this.parents = parents;
        }

        /**
         * Get the list of children of the person.
         * 
         * @return children - children of person
         */
        public ArrayList<Person> getChildren() {
            return (ArrayList<Person>) children;
        }

        /**
         * Set the list of children of the person.
         * 
         * @param children - children of person
         */
        public void setChildren(ArrayList<Person> children) {
            this.children = children;
        }

        /**
         * Add a parent to the person.
         * 
         * @param parent - parent to be added
         */
        public void addParent(Person parent) {
            this.parents.add(parent);
        }

        /**
         * Add a child to the person.
         * 
         * @param child - child to be added
         */
        public void addChild(Person child) {
            this.children.add(child);
        }
    }

}
