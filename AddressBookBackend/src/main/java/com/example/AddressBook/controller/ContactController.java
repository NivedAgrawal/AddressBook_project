package com.example.AddressBook.controller;

import com.example.AddressBook.model.Contact;
import com.example.AddressBook.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service){
        this.service = service;
    }

    // UC1 Add Contact
    @PostMapping
    public String addContact(@RequestBody Contact contact){
        return service.addContact(contact);
    }

    // UC2 Edit Contact
    @PutMapping("/{name}")
    public String editContact(@PathVariable String name,
                              @RequestBody Contact contact){
        return service.editContact(name, contact);
    }

    // UC3 Delete Contact
    @DeleteMapping("/{name}")
    public String deleteContact(@PathVariable Long id){
        return service.deleteContact(id);
    }

    // UC4 View All Contacts
    @GetMapping
    public List<Contact> getContacts(){
        return service.getAllContacts();
    }

    // UC7 Search by City
    @GetMapping("/city/{city}")
    public List<Contact> searchByCity(@PathVariable String city){
        return service.searchByCity(city);
    }

    // UC7 Search by State
    @GetMapping("/state/{state}")
    public List<Contact> searchByState(@PathVariable String state){
        return service.searchByState(state);
    }

    // UC8 View Persons by City
    @GetMapping("/view/city")
    public Map<String, List<Contact>> viewByCity(){
        return service.viewByCity();
    }

    // UC8 View Persons by State
    @GetMapping("/view/state")
    public Map<String, List<Contact>> viewByState(){
        return service.viewByState();
    }

    // UC9 Count Contacts by City
    @GetMapping("/count/city")
    public Map<String, Long> countByCity(){
        return service.countByCity();
    }

    // UC9 Count Contacts by State
    @GetMapping("/count/state")
    public Map<String, Long> countByState(){
        return service.countByState();
    }

    // UC10 Sort Contacts by Name
    @GetMapping("/sort/name")
    public List<Contact> sortByName(){
        return service.sortByName();
    }
    
    @GetMapping("/sort/city")
    public List<Contact> sortByCity(){
    	return service.sortByCity();
    }
    @GetMapping("/sort/state")
    public List<Contact> sortByState(){
        return service.sortByState();
    }

    @GetMapping("/sort/zip")
    public List<Contact> sortByZip(){
        return service.sortByZip();
}
}


