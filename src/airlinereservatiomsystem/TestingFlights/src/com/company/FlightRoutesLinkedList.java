package com.company;

public class FlightRoutesLinkedList {

    NodeFlightRoute head;

    public FlightRoutesLinkedList() {
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public int addRoute(City[] cities) {
        NodeFlightRoute route = new NodeFlightRoute();
        for(int i=0; i<cities.length-1;i++){
//            NodeFlight flight = new NodeFlight(cities[i],cities[i+1]);
            route.flights.addFlight(cities[i],cities[i+1]);
        }
        insertLast(route);
        return route.getRouteId();
    }


    private void insertLast(NodeFlightRoute newNode){

        if (isEmpty()) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeFlightRoute currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.next = null;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return;
        }
        System.out.println("FLight Routes Linked list: ");
        NodeFlightRoute current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }
}
