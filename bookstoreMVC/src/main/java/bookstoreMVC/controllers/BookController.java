package bookstoreMVC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookstoreMVC.beans.Book;
import bookstoreMVC.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService service;
	
	// GET ALL
	@CrossOrigin
	@RequestMapping(
		method=RequestMethod.GET, 
		produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAll() {
		return service.getAll();
	}

	// GET BY ID
	@CrossOrigin
	@RequestMapping(
		value="/{id}", 
		method=RequestMethod.GET, 
		produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> findById(@PathVariable int id) {
		Book a = service.getById(id);
		if ( a == null ) {
			return new ResponseEntity<Book>(HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<Book>(a, HttpStatus.OK);
		}
	}

	// CREATE
	@CrossOrigin
	@RequestMapping(
		method=RequestMethod.POST,
		consumes=MediaType.APPLICATION_JSON_VALUE,
		produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addBook(@RequestBody Book a) {
		Book book = service.addBook(a);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Book>(a, HttpStatus.CREATED);
		}
	}
	
	// UPDATE
	@CrossOrigin
	@RequestMapping(
		value="/{id}", 
		method=RequestMethod.PUT,
		consumes=MediaType.APPLICATION_JSON_VALUE,
		produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book a) {
		Book book = service.updateBook(id, a);
		if(book == null) {
			return new ResponseEntity<Book>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Book>(a, HttpStatus.OK);
		}
	}
	
}
