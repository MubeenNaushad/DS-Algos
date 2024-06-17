package com.company;

public class BST {

    private class Node {
        private int data; // Creating private var data in private class Node.
        private Node leftchild; // Creating Nodes (from class name) to get lower values.
        private Node rightchild; // Creating Nodes (from class name) to get higher values.


        public Node(int data){ // Constructor calling
            this.data = data; // To assign value.
        }

        public String toString(){
           return "Value " + data;
        }
    }

    private Node root; // Creating a base node called root.

    public void insert(int val){ // Calling constructor to make it public to pass private variable.
        root = insert(root, val); // Storing values.
    }
    private Node insert(Node root, int val){ // Private function to insert variable.
        if(root == null){ // If root is empty.
            root = new Node(val); // Insert in root.
            return root; // then return root.
        }
        Node curr = root; // If not empty then
        if (val < curr.data){ // Check if value lower than root data.
            if(curr.leftchild == null){ // If value lower then go left
                curr.leftchild = new Node (val); // store in left if empty

            } insert(curr.leftchild, val); // if left not empty then call again to go further.
        }
        else if (val > curr.data){ // Check if value greater than root data.
            if(curr.rightchild == null){ // If value greater then go right
                curr.rightchild = new Node (val); //

            } insert(curr.rightchild, val);
        }

        return root;
    }

    public boolean findInt(int val){
        return findInt(root, val);
    }
    private boolean findInt(Node root, int val){
        Node curr = root;
        if(root == null)
            return false;
        while (curr != null) {
            if (val < curr.data) {
                curr = curr.leftchild;
            }
            else if (val > curr.data) {
                curr = curr.rightchild;
            } else {
                return true;
            }
        }
        return false;
    }

    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root == null)
            return -1;
        else if (root.leftchild == null && root.rightchild == null)
            return 0;

        return 1+Math.max(height(root.leftchild), height(root.rightchild));
    }

    public boolean equality(BST other){
        return equality(root, other.root);
    }
    private boolean equality(Node one, Node two){
        if (one == null && two == null){
            return true;
        } else if (one.data == two.data && equality(one.leftchild, two.leftchild) && equality(one.rightchild, two.rightchild)){
            return true;
        }
        return false;
    }

    public void PostOrder(){
        PostOrder(root);
    }
    private void PostOrder(Node root){
        if(root == null)
            return;
        PostOrder(root.leftchild);
        PostOrder(root.rightchild);
        System.out.print(root.data + ", ");
    }

    public void PreOrder(){
        PreOrder(root);
    }
    private void PreOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.data + ", ");
        PreOrder(root.leftchild);
        PreOrder(root.rightchild);
    }

    public void InOrder(){
        InOrder(root);
    }
    private void InOrder(Node root){
        if(root == null)
            return;
        InOrder(root.leftchild);
        System.out.print(root.data + ", ");
        InOrder(root.rightchild);
    }

    public int MaxVal(){
        return MaxVal(root);
    }

    public int MinVal(){
        return MinimumVal(root);
    }
    private int MaxVal(Node root){
        if(root == null)
            return 0;
        Node curr = root;
        while(curr.rightchild != null) {
            curr = curr.rightchild;
        }
        return curr.data;
    }

    private int MinimumVal(Node root){
        if(root == null)
            return 0;
        Node curr = root;
        while(curr.leftchild != null) {
            curr = curr.leftchild;
        }
        return curr.data;
    }
}
