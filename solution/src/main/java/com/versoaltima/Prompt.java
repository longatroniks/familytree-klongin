package com.versoaltima;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

/**
 * This class prompts the user to enter
 * relationships between people and then
 * add these relationships to a list which
 * is sent to the FamilyTree class.
 */
public class Prompt {

    /**
     * Prompts the user to enter relationships.
     * 
     * @return List of relationships
     */
    public static ArrayList<String> prompt() {
        List<String> relationships = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.printf("\n%-30s %5s%d", "Number of relationships", ": ", counter);
            System.out.printf("\n%-30s %5s", "Add new relationship?(y/n)", ": ");
            String input = in.nextLine();

            if (!(input.toLowerCase().charAt(0) == ('y')) || input == null) {
                System.out.println("\nThank you for using this program!");
                break;
            }

            System.out.printf("\n%-30s %5s", "Enter a child name", ": ");
            String child = in.nextLine();
            System.out.printf("%-30s %5s", "Enter a parent name", ": ");
            String parent = in.nextLine();

            if (child.equals("") || parent.equals("") || child == null || parent == null) {
                System.out.println("\nERROR: Both parent and child names are required");
                break;
            }

            relationships.add(child + " " + parent);
            counter++;
        }

        in.close();
        return (ArrayList<String>) relationships;
    }
}
