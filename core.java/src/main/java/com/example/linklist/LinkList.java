package com.example.linklist;

public class LinkList {

    Node head = null;
    Node tail = null;

    private class Node<E> {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        int[] nodeValues = {7, 6, 5, 4, 3, 2, 1};

        for ( int i : nodeValues ) {
            linkList.addToTheEnd(i);
        }

        linkList.printLinkList();
        System.out.println("Middle node value: " + linkList.findMiddle());
    }

    public void addToTheEnd(int value) {

        Node node = new Node(value);

        node.next = head;
        head = node;
    }

    public void printLinkList() {
        Node current = head;

        while ( current != null) {
            System.out.println("node value: "+ current.value);
            current = current.next;
        }
    }


    public int findMiddle() {
        int middleValue = 0;
        Node fastMover = head;
        Node slowMover = head;

        while (fastMover != null && fastMover.next != null) {

            //jump by 1
            slowMover = slowMover.next;

            // jump by 2
            fastMover = fastMover.next.next;
        }

        return slowMover.value;
    }


}
