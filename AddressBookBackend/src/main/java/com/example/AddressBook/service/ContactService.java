package com.example.AddressBook.service;

import com.example.AddressBook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import com.example.AddressBook.repository.ContactRepo;
@Service
public class ContactService {

//    private List<Contact> contacts = new ArrayList<>();
//
//    // UC1 Add Contact
//    public String addContact(Contact contact){
//
//        // UC6 Duplicate Check using Streams
//        boolean exists = contacts.stream()
//                .anyMatch(c -> c.getFirstName()
//                .equalsIgnoreCase(contact.getFirstName()));
//
//        if(exists){
//            return "Duplicate Contact Not Allowed";
//        }
//
//        contacts.add(contact);
//        return "Contact Added Successfully";
//    }
//
//    // UC2 Edit Contact
//    public String editContact(String name, Contact updated){
//        for(Contact c : contacts){
//            if(c.getFirstName().equalsIgnoreCase(name)){
//                c.setAddress(updated.getAddress());
//                c.setCity(updated.getCity());
//                c.setPhoneNumber(updated.getPhoneNumber());
//                return "Contact Updated";
//            }
//        }
//        return "Contact Not Found";
//    }
//
//    // UC3 Delete Contact
//    public String deleteContact(String name){
//        contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(name));
//        return "Contact Deleted";
//    }
//
//    // UC4 Get All Contacts
//    public List<Contact> getAllContacts(){
//        return contacts;
//    }
//
//
//    // UC7 Search by City
//    public List<Contact> searchByCity(String city){
//        return contacts.stream()
//                .filter(c -> c.getCity().equalsIgnoreCase(city))
//                .collect(Collectors.toList());
//    }
//
//
//    // UC7 Search by State
//    public List<Contact> searchByState(String state){
//        return contacts.stream()
//                .filter(c -> c.getState().equalsIgnoreCase(state))
//                .collect(Collectors.toList());
//    }
//
//
//    // UC8 View Persons by City
//    public Map<String, List<Contact>> viewByCity(){
//        return contacts.stream()
//                .collect(Collectors.groupingBy(Contact::getCity));
//    }
//
//
//    // UC8 View Persons by State
//    public Map<String, List<Contact>> viewByState(){
//        return contacts.stream()
//                .collect(Collectors.groupingBy(Contact::getState));
//    }
//
//
//    // UC9 Count by City
//    public Map<String, Long> countByCity(){
//        return contacts.stream()
//                .collect(Collectors.groupingBy(
//                        Contact::getCity,
//                        Collectors.counting()
//                ));
//    }
//
//
//    // UC9 Count by State
//    public Map<String, Long> countByState(){
//        return contacts.stream()
//                .collect(Collectors.groupingBy(
//                        Contact::getState,
//                        Collectors.counting()
//                ));
//    }
//
//
//    // UC10 Sort Contacts by Name
//    public List<Contact> sortByName(){
//        return contacts.stream()
//                .sorted(Comparator.comparing(Contact::getFirstName))
//                .collect(Collectors.toList());
//    }
//
//    //UC11 sort by city
//	public List<Contact> sortByCity() {
//		return contacts.stream()
//				.sorted(Comparator.comparing(Contact::getCity))
//				.toList();
//	}
	
	//By using JPA
	    private final ContactRepo repo;

	    public ContactService(ContactRepo repo){
	        this.repo = repo;
	    }

	    // Add Contact
	    public String addContact(Contact contact){
	        repo.save(contact);
	        return "Contact Saved in DB";
	    }

	    // Get All
	    public List<Contact> getAllContacts(){
	        return repo.findAll();
	    }

//	    // UC2 Edit Contact
	    public String editContact(String name, Contact updated) {

	        Contact c = repo.findByFirstNameIgnoreCase(name);

	        if (c != null) {
	            c.setAddress(updated.getAddress());
	            c.setCity(updated.getCity());
	            c.setPhoneNumber(updated.getPhoneNumber());

	            repo.save(c);

	            return "Contact Updated";
	        }

	        return "Contact Not Found";
	    }
	    // UC8 View Persons by City
	    public Map<String, List<Contact>> viewByCity(){
	        return repo.findAll().stream()
	                .collect(Collectors.groupingBy(Contact::getCity));
	    }
	
	
	    // UC8 View Persons by State
	    public Map<String, List<Contact>> viewByState(){
	        return repo.findAll().stream()
	                .collect(Collectors.groupingBy(Contact::getState));
	    }
	
	
	    // UC9 Count by City
	    public Map<String, Long> countByCity(){
	        return repo.findAll().stream()
	                .collect(Collectors.groupingBy(
	                        Contact::getCity,
	                        Collectors.counting()
	                ));
	    }
	
	
	    // UC9 Count by State
	    public Map<String, Long> countByState(){
	        return repo.findAll().stream()
	                .collect(Collectors.groupingBy(
	                        Contact::getState,
	                        Collectors.counting()
	                ));
	    }
	    // Delete by ID
	    public String deleteContact(Long id){
	        repo.deleteById(id);
	        return "Contact Deleted";
	    }

	    // Search by City
	    public List<Contact> searchByCity(String city){
	        return repo.findByCity(city);
	    }

	    // Search by State
	    public List<Contact> searchByState(String state){
	        return repo.findByState(state);
	    }

	    // Sort by City
	    public List<Contact> sortByCity(){
	        return repo.findAll()
	                .stream()
	                .sorted(Comparator.comparing(Contact::getCity))
	                .toList();
	    }

	    // Sort by State
	    public List<Contact> sortByState(){
	        return repo.findAll()
	                .stream()
	                .sorted(Comparator.comparing(Contact::getState))
	                .toList();
	    }

	    // Sort by Zip
	    public List<Contact> sortByZip(){
	        return repo.findAll()
	                .stream()
	                .sorted(Comparator.comparing(Contact::getZip))
	                .toList();
	    }
	    //sort by name
	    public List<Contact> sortByName(){
	        return repo.findAll().stream()
	                .sorted(Comparator.comparing(Contact::getFirstName))
	                .collect(Collectors.toList());
	    }
}


