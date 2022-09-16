package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    @ManyToMany(mappedBy="addresses")
    @JoinTable
    private Set<Person> owners;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Collection<Person> getOwners() {
        return owners;
    }

    public void setOwners(Set<Person> owners) {
        this.owners = owners;
    }
}
