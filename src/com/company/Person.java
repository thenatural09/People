package com.company;

/**
 * Created by Troy on 9/26/16.
 */
public class Person implements Comparable {
    int id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ipAddress;

    public Person(int id, String firstName, String lastName, String email, String country, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ipAddress = ipAddress;
    }

    public int getId() {
        return id;
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
        return country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                firstName +
                lastName +
                "from" + country +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.lastName.compareTo(p.lastName);
    }
}


