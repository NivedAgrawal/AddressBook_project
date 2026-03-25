package com.example.AddressBook.repository;

import com.example.AddressBook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Long> {

    List<Contact> findByCity(String city);

    List<Contact> findByState(String state);
    
    Contact findByFirstNameIgnoreCase(String firstName);
}
