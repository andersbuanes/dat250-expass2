package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person();
        person.setName("Max Mustermann");

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);

        Set<Person> owners = new HashSet<>();
        owners.add(person);

        person.setAddresses(addresses);
        address.setOwners(owners);
        em.persist(address);

        Bank bank = new Bank();
        bank.setName("Pengebank");

        Pincode pincode = new Pincode();
        pincode.setCount(1);
        pincode.setPincode("123");
        em.persist(pincode);

        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBalance(-5000);
        card1.setLimit(-10000);
        card1.setPincode(pincode);
        card1.setOwningBank(bank);

        CreditCard card2 = new CreditCard();
        card2.setNumber(123);
        card2.setBalance(1);
        card2.setLimit(2000);
        card2.setPincode(pincode);
        card2.setOwningBank(bank);

        Set<CreditCard> cards = new HashSet<>();
        cards.add(card1);
        cards.add(card2);

        bank.setOwnedCards(cards);
        person.setCreditCards(cards);
        em.persist(bank);
        em.persist(card1);
        em.persist(card2);
        em.persist(person);

        em.getTransaction().commit();
        em.close();
    }
}
