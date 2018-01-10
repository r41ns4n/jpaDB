package com.sabel.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Person person = new Person("Peter", 45);
        person.setAdresse(new Adresse("Peterweg", "101a", 12345, "Pertershausen"));
        Person person1 = new Person("Hans", 18);
        person1.setAdresse(new Adresse("Hansweg", "102b", 23456, "Hanshausen"));
        Person person2 = new Person("Mueller", 23);
        person2.setAdresse(new Adresse("Muellerweg", "103c", 34567, "Muerllershausen"));
        PersonService personService = new PersonService();

        personService.save(person);
        personService.save(person1);
        personService.save(person2);

        Person personAusDB = personService.findPerson(1);
        if (personAusDB != null) {
            System.out.println(personAusDB);
        }

        List<Person> people = personService.giveAllPersons();
        for (Person person3: people) {
            System.out.println(person3);
        }

        personService.close();

    } // END MAIN

} // END CLASS MAIN
