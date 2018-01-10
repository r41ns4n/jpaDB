package com.sabel.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonService {

    // DATA FIELDS
    private EntityManagerFactory emf;
    private EntityManager em;

    // CONSTRUCTOR
    public PersonService() {
        emf = Persistence.createEntityManagerFactory("personenverwaltung");
        em = emf.createEntityManager();
    }

    public void save(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        System.out.println(person.toString() + "in DB gespeichert");
    } // END public void save(Person person)

    public Person findPerson(int id) {
        return em.find(Person.class, id);
    } // END  public Person findPerson(int id)

    public List<Person> giveAllPersons() {
        TypedQuery<Person> query = em.createQuery("SELECT p from Person p", Person.class);
        return query.getResultList();
    } // END public List<Person> giveAllPersons()

    public void close() {
        if (em != null) {
            em.close();
        } // END IF EM
        em = null;

        if (emf != null) {
            emf.close();
        } // END IF EMF
        emf = null;
    } // END public void close()

} // END CLASS PERSONSERVICE
