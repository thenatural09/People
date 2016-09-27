package com.company;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
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

        for (Person person : peopleList) {
            Collections.sort(peopleList);
            String country = person.country;
            if(!personMap.containsKey(country)) {
                personMap.put(country,new ArrayList<>());
            } else {
                personMap.get(country).add(person);
            }
        }
    }

    public static void writeToJson(ArrayList<Person> peopleList,String fileName) throws IOException {
        File f1 = new File(fileName);
        JsonSerializer serializer = new JsonSerializer();
        PersonWrapper pw = new PersonWrapper(peopleList);
        pw.people = peopleList;
        String json = serializer.deep(true).serialize(pw);
        FileWriter fw = new FileWriter(f1);
        fw.write(json);
        fw.close();
    }
}
