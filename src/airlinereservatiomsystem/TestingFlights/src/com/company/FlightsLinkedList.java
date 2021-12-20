package com.company;

import java.time.LocalDateTime;

public class FlightsLinkedList {


    public int getCount() {
        return count;
    }

    private int count = 0;

    public NodeFlight head;


    public FlightsLinkedList(){

    }

    public boolean isEmpty(){
        return (head == null);
    }

    public int addFlight(City source,City destination){
        NodeFlight flight = new NodeFlight(source,destination);
        insertLast(flight);
        return flight.getFlightId();
    }

    private void insertLast(NodeFlight newNode){
        if (isEmpty()) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeFlight currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.next = null;
        }
        this.count++;
    }



    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return;
        }
        System.out.println("Flights Linked list: ");
        NodeFlight current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }


}
