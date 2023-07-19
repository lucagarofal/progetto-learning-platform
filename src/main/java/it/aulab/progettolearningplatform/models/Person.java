package it.aulab.progettolearningplatform.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Person {
    
    @Column(length = 100, nullable = false)
    private String firstname;
    @Column(length = 100, nullable = false)
    private String lastname;
    
    public Person() {
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}
