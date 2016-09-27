package com.company;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Person> peopleList = readTxtFile();
        HashMap<String,ArrayList<Person>> personMap = sortPeoplList(peopleList);
        writeToJson(personMap, "people.json");
        System.out.println(personMap.toString());
    }


    public static void writeToJson(HashMap<String,ArrayList<Person>> personMap,String fileName) throws IOException {
        File f1 = new File(fileName);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(personMap.toString());
        FileWriter fw = new FileWriter(f1);
        fw.write(json);
        fw.close();
    }

    public static HashMap<String,ArrayList<Person>> sortPeoplList (ArrayList<Person> peopleList) throws FileNotFoundException {
        HashMap<String,ArrayList<Person>> personMap = new HashMap<>();
        for(Person person : peopleList) {
            String country = person.countryName;
            if (!personMap.containsKey(country)) {
                personMap.put(country, new ArrayList<>());
            } else {
                personMap.get(country).add(person);
                Collections.sort(personMap.get(country));
            }
        }
        return personMap;
    }

    public static ArrayList<Person> readTxtFile() throws FileNotFoundException {
        ArrayList<Person> peopleList = new ArrayList<>();
        File f = new File("people.txt");
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");
            String personId = columns[0];
            String firstName = columns[1];
            String lastName = columns[2];
            String email = columns[3];
            String countryName = columns[4];
            String ipAddress = columns[5];
            Person p = new Person(Integer.valueOf(personId), firstName, lastName, email, countryName, ipAddress);
            peopleList.add(p);
        }
        return peopleList;
    }
}
