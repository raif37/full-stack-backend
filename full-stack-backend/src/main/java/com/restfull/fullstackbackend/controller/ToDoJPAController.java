package com.restfull.fullstackbackend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfull.fullstackbackend.dao.TodoJpaRepository;
import com.restfull.fullstackbackend.dto.Todo;
import com.restfull.fullstackbackend.service.ToDoHardCodedService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoJPAController {
	
	@Autowired
	private ToDoHardCodedService toDoHardCoded;
	
	@Autowired
	private TodoJpaRepository toDoJpaRepo;
	
	@RequestMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return toDoJpaRepo.findByUsername(username);
	}
	
	@RequestMapping("/jpa/users/{username}/get-todo/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable Long id){
		return toDoJpaRepo.findById(id).get();
//		return toDoHardCoded.findById(id);
	}
	
	@RequestMapping("/jpa/users/{username}/delete-todo/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable Long id){
//		Todo todo =  toDoHardCoded.deleteById(id);
		
		toDoJpaRepo.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
		
		//return ResponseEntity.notFound().build();
	}
	
	@RequestMapping("/jpa/users/{username}/update-todo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable Long id, @RequestBody Todo todo){
		Todo todoUpdated =  toDoJpaRepo.save(todo);
		
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}
	
	@RequestMapping("/jpa/users/{username}/create-todo")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo){
		todo.setUsername(username);
		System.out.println(username);
		Todo todoCreated =  toDoJpaRepo.save(todo);
		
		//Get Url of current resource and append id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}



}
