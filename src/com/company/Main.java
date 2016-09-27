package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String,ArrayList<Person>> personMap = new HashMap<>();
        ArrayList<Person> peopleList = new ArrayList<>();
        File f = new File("people.txt");
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");
            String id = columns[0];
            String firstName = columns[1];
            String lastName = columns[2];
            String email = columns[3];
            String country = columns[4];
            String ipAddress = columns[5];
            Person p = new Person(Integer.valueOf(id),firstName,lastName,email,country,ipAddress);
            peopleList.add(p);
        }
    }
}
