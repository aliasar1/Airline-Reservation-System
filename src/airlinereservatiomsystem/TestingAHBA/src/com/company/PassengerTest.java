package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PassengerTest {
    public String passengerName;
    public String gender;
    public int passportNumber;
    public String nationality;
    public int passengerId; // generated automatically
    public String sourceCity;
    public String departureCity;

    //Linked List
    private NodePassenger head;
    private static int counter = 1;

    public boolean isEmpty(){
        return (head == null);
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Linked list is empty!");
            return;
        }
        System.out.println("Linked list: ");
        NodePassenger current = head;
        while (current != null){
            current.display();
            current = current.next;
        }
    }

    public void insertFirst(String data){
        NodePassenger newNode = new NodePassenger();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void addPassenger(String name, String gender, int passportNumber, String nationality, String source, String destination){

        insertFirst(counter +"-"+ name +"-"+ gender +"-"+ passportNumber +"-"+ nationality +"-"+ source +"-"+ destination);
        counter++;
        writeInFile(head);
    }

    public void createLinkList(){
        File f = new File("filename.txt");
        if (!f.exists()){
            return;
        }
        Scanner readData = null;
        try {
            readData = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (readData.hasNextLine()) {
            String data = readData.nextLine();
            insertFirst(data);
        }
        readData.close();
    }

    public void writeInFile(NodePassenger passenger) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt", true);
            try {
                myWriter.write(passenger.data + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int listLength(){
        NodePassenger current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void deleteFromPosition(int pos){
        if (isEmpty()){
            System.out.println("List is already empty.");
        }
        else if (pos > listLength() || pos < 1){
            System.out.println("Invalid position!");
        }
        else if(head.next == null && pos == 1){
            head = null;
        }
        else if (pos == 1){
            NodePassenger temp = head;
            head = head.next;
            temp.next = null;
        }
        else {
            NodePassenger temp = head;
            int i = 1;
            while (i < pos-1){
                temp = temp.next;
                pos--;
            }
            temp.next = temp.next.next;
        }
        removePosFromFile();
    }

    public void deleteID(int id){
        NodePassenger current = head;
        int pos = 0;
        while (current != null) {
            pos++;
            String[] getID = current.data.split("-");
            if (Integer.parseInt(getID[0]) == id) {
                //logic
                deleteFromPosition(pos);
            }
            current = current.next;
        }
    }

    public void removePosFromFile(){
        File f = new File("filename.txt");
        if (f.exists()){
            f.delete();
        }
        writeAllData();
    }

    public void writeAllData(){
        NodePassenger current = head;
        while (current != null){
            writeInFile(current);
            current = current.next;
        }
    }

    public void searchData(int id){
        NodePassenger current = head;
        while (current != null){
            String[] getID = current.data.split("-");
            if (Integer.parseInt(getID[0]) == id){
                //logic
                System.out.println("Data found for id " + id + " :");
                for (int i=0; i<getID.length; i++){
                    System.out.println(getID[i]);
                }
            }
            current = current.next;
        }
    }

    public void replaceNodeData(int id){
        NodePassenger current = head;
        while (current != null){
            String[] getID = current.data.split("-");
            if (Integer.parseInt(getID[0]) == id){
                //logic
                int pID = Integer.parseInt(getID[0]);
                counter = pID;
                // This would be input by user but for testing passing directly
                deleteID(id);
                addPassenger("Ena", "Female", 235, "Pakistani", "Karachi", "Islamabad");

            }
            current = current.next;
        }
    }

}
