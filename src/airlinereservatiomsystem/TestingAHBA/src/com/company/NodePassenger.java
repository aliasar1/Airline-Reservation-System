package com.company;

public class NodePassenger {
    public NodePassenger next;
    public String data;

    public void display() {
        if (next == null) {
            System.out.print(data + " --> null\n");
        } else
            System.out.print(data + " --> ");
    }
}
