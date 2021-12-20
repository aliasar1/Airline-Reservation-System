package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PassengerTest pt = new PassengerTest();
        pt.createLinkList();
        pt.addPassenger("Ali", "Male", 312, "Pakistani", "Karachi", "Islamabad");
        pt.addPassenger("Hammad", "Male", 235, "Pakistani", "Karachi", "Islamabad");
        pt.addPassenger("Bilal", "Male", 235, "Pakistani", "Karachi", "Islamabad");
        pt.addPassenger("Aleem", "Male", 235, "Pakistani", "Karachi", "Islamabad");
        pt.display();
        pt.deleteID(3);
        pt.display();

        pt.searchData(2);
        pt.display();

        pt.deleteID(2);
        pt.display();

        pt.replaceNodeData(1);
        pt.display();

        pt.deleteID(1);
        pt.display();
    }
}
