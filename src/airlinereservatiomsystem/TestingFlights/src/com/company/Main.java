package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        City city1 = new City("karachi");
        City city2 = new City("islamabad");
        City city3 = new City("dubai");
        City city4 = new City("u.k");

        City[] cities = {city1,city2,city3,city4};

        FlightRoutesLinkedList fl = new FlightRoutesLinkedList();
        fl.addRoute(cities);

        fl.display();

    }
}
