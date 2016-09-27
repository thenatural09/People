package com.company;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Troy on 9/27/16.
 */
public class MainTest {
    @Test
    public void testReadTxtFile() throws FileNotFoundException {
        ArrayList<Person> peopleList = Main.readTxtFile("peopletest.txt");
        assertTrue(!peopleList.isEmpty());
    }

    @Test
    public void testSortPeople() throws FileNotFoundException {
        ArrayList<Person> peopleList = Main.readTxtFile("peopletest.txt");
        HashMap<String,ArrayList<Person>> personMap = Main.sortPeoplList(peopleList);
        assertTrue(!personMap.isEmpty());
    }
}