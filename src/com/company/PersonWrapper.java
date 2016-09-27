package com.company;

import java.util.ArrayList;

/**
 * Created by Troy on 9/26/16.
 */
public class PersonWrapper {
    ArrayList<Person> people;

    public PersonWrapper() {
    }

    public PersonWrapper(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
