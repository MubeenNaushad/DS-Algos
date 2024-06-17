package com.company;

public class BSTMain {

    public static void main(String[] args) {
	// write your code here
        BST tree = new BST();

        tree.insert(17);
        tree.insert(14);
        tree.insert(19);
        tree.insert(11);
        tree.insert(16);
        tree.insert(18);
        tree.insert(20);

        BST tree2 = new BST();
        tree2.insert(17);
        tree2.insert(14);
        tree2.insert(19);
        tree2.insert(11);
        tree2.insert(16);
        tree2.insert(18);
        tree2.insert(20);

        System.out.println("\nFound: ");
        System.out.println(tree.findInt(18));
        System.out.println("Height: ");
        System.out.println(tree.height());
        System.out.println("Equality: ");
        System.out.println(tree.equality(tree2));
        System.out.println("Post Order:");
        tree.PostOrder();
        System.out.println("\nPre Order:");
        tree.PreOrder();
        System.out.println("\nIn Order:");
        tree.InOrder();
        System.out.println("\nMax: ");
        System.out.println(tree.MaxVal());
        System.out.println("Min: ");
        System.out.println(tree.MinVal());
    }
}
