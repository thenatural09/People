package com.company;

/**
 * Created by Troy on 9/26/16.
 */
public class Person implements Comparable {
    int personId;
    String firstName;
    String lastName;
    String email;
    String countryName;
    String ipAddress;
    public Person() {

    }

    public Person(int personId, String firstName, String lastName, String email, String countryName, String ipAddress) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.countryName = countryName;
        this.ipAddress = ipAddress;
    }

    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return countryName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return "{" + firstName + " " +  lastName + " " + "from " + countryName + '}';
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.lastName.compareTo(p.lastName);
    }
}


