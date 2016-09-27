package com.company;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Troy on 9/27/16.
 */
public class MainTest {
    @Test
    public void testReadTxtFile() throws FileNotFoundException {
        File f = new File("people.txt");
        Person person = new Person();
        person.countryName = "France";
        ArrayList<Person> peopleList = Main.readTxtFile();
        assertTrue(peopleList.contains(person));
    }
}