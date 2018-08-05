package com.example.tree;

public class TreeTraversal {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node rootNode;

    public TreeTraversal() {
        addNode(rootNode, 45);
        addNode(rootNode, 25);
        addNode(rootNode, 75);
        addNode(rootNode, 15);
        addNode(rootNode, 35);
    }

    public void addNode(Node rootNode, int data) {
        if (rootNode == null) {
            Node tmp = new Node(data);
            this.rootNode = tmp;
        } else {
            addChildNode(rootNode, data);
        }
    }

    public void addChildNode(Node rootNode, int data) {
        if (data > rootNode.data) {
            if (rootNode.right != null){
                addNode(rootNode.right, data);
            } else {
              Node temp = new Node(data);
              rootNode.right = temp;
            }
        } else {

        }
    }
}
