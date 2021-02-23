package com.example.datastructure.linkedlist;

//import lombok.AllArgsConstructor;
//import lombok.Data;

//@Data
public class ExampleLinkedList {
    private Node head;
    private int counter;

    public void add(Object data) {

    }

    public void add(Object data, int index) {

    }

    public Object get(int index) {
        return new Node(new String(""), head);
    }

    public void remove(int index) {

    }


 //   @Data
   // @AllArgsConstructor
    private class Node<T> {
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        private Object data;
        private Node next;
    }
}
