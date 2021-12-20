package com.company;

import java.time.LocalDateTime;

public class NodeFlight {
    static int counter = 0;
    private int flightId;
    public LocalDateTime flightTime;
    public City source;
    public City destination;

    public NodeFlight next = null;

    public NodeFlight( /*LocalDateTime flightTime,*/ City source, City destination) {
        this.flightId = counter;
//        this.flightTime = flightTime;
        this.source = source;
        this.destination = destination;
        counter++;
    }


    public void display(){
            System.out.print(source.name + " --> " + destination.name +"\n");
    }

    public int getFlightId() {
        return flightId;
    }


}
