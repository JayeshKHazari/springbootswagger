package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.datamodel.Contact;

@RestController
@RequestMapping("/api")
public class AddressBookRestController {
	
	ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

	@GetMapping("/{id}")
	public Contact getContactByPathParam(@PathVariable String id)
	{
		return contacts.get(id);
	}
	
	@GetMapping("/contact")
	public Contact getContactByQueryParam(@RequestParam(defaultValue = "test") String id) {
	    return contacts.get(id);
	}
	
	@GetMapping("/")
	public List<Contact> getAllContact()
	{
		return new ArrayList<Contact>(contacts.values());
	}
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact)
	
	{
		contacts.put(contact.getId(),contact);
		return contact;
	}
	
	
	
}
