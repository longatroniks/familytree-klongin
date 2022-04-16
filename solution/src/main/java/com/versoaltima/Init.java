package com.versoaltima;

/**
 * Main class.
 */
public class Init {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree(Prompt.prompt());
        tree.printTree();
    }
}
