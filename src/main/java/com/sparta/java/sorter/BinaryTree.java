package com.sparta.java.sorter;

import java.util.ArrayList;

public class BinaryTree {

    Node root;
    int nodeCount;

    public class Node {
        private int val;
        private Node left;
        private Node right;

        private Node (int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public BinaryTree() {
        this.root = null;
        this.nodeCount = 0;
    }

    public BinaryTree(int[] arr) {
        this.root = null;
        this.nodeCount = 0;
        for(int element : arr) {
            this.add(element);
        }
    }

    public void add(int val) {
        root = add(root, val); // start recursion from the root node
    }

    public int[] getInOrder() {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        traverseInOrder(this.root, arrList); // add values to ArrayList
        return arrList.stream().mapToInt(i->i).toArray(); // convert ArrayList to int[]
    }

    private Node add(Node current, int val) {
        // if the node doesn't exist; make it
        if(current == null) {
            nodeCount++;
            return new Node(val);
        }

        // if the node exists
        if(val <= current.val) {
            current.left = add(current.left, val);
        } else if (val > current.val) {
            current.right = add(current.right, val);
        } else { // else; value already exists
            return current;
        }

        return current;
    }

    private void traverseInOrder(Node current, ArrayList<Integer> arrList) {
        // if the node doesn't exist; end of branch has been reached
        if(current == null) {
            return;
        }
        traverseInOrder(current.left, arrList); // traverse left branch
        arrList.add(current.val);
        traverseInOrder(current.right, arrList); // traverse right branch
    }


}
