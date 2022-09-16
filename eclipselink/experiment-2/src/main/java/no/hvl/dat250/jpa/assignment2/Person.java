package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name="person_address")
    private Set<Address> addresses;

    @OneToMany
    private Set<CreditCard> creditCards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards){
        this.creditCards = creditCards;
    }
}
