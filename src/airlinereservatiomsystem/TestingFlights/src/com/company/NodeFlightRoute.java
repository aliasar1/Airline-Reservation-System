package com.company;

public class NodeFlightRoute {

    static int counter = 0;

    public int getRouteId() {
        return routeId;
    }

    int routeId;
    FlightsLinkedList flights;

    public NodeFlightRoute next = null;


    public NodeFlightRoute(){

        this.routeId = counter;
        counter++;
        flights  = new FlightsLinkedList();
    }
    // helper function to find the best route
    public City[] getCities(){
        int i =0;
        NodeFlight current = flights.head;
        City[] cities = new City[flights.getCount()+1];
        while (current != null) {
            cities[i] = current.source;
            current = current.next;
            i += 1;
        }
        cities[i] = current.destination;
        return cities;
    }

    public void display(){
        System.out.println("Route ID: "+this.routeId+ "{ ");
        flights.display();
        System.out.println( " }");
    }
}
