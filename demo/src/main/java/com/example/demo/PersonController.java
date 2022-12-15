package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private RabbitTemplate template;
	
	@GetMapping("/{name}")
	public Person getAllPersons(@PathVariable String name){
		Person person = new Person(1,name, 30);
	    //Returns hardcoded data, a real world application would return from the database
	    /*List<Person> personList = new ArrayList<Person>();
	    personList.add(new Person(1,"Mickey Mouse", 30));
	    personList.add(new Person(2,"Donald Duck", 35));
	    personList.add(new Person(3,"Peppa Pig", 15));*/
		
	    template.convertAndSend("demo_exchange", "demo_routing_key", person);
	    return person;
	} 
}
