package com.versoaltima;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        List<String> relationships = new ArrayList<>();
        relationships.add("Adam Ivan");
        relationships.add("Marko Stjepan");
        relationships.add("Stjepan Adam");
        relationships.add("Robert Stjepan");
        relationships.add("Fran Ivan");
        relationships.add("Leopold Luka");

        FamilyTree tree = new FamilyTree(relationships);
        tree.printTree();
        assertEquals(6, tree.getNumOfRecursions());
    }
}
