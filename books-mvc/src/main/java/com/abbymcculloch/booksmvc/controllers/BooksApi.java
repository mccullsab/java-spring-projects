package com.abbymcculloch.booksmvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abbymcculloch.booksmvc.model.Book;
import com.abbymcculloch.booksmvc.services.BookService;

@RestController
public class BooksApi {
 private final BookService bookService;
 public BooksApi(BookService bookService){
     this.bookService = bookService;
 }
 
 @GetMapping("/api/books")
 public List<Book> findAllBook(){
	 return bookService.allBooks();
 }

 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
 public Book update(
 		@PathVariable("id") Long id, 
 		@RequestParam(value="title") String title, 
 		@RequestParam(value="description") String description, 
 		@RequestParam(value="language") String lang,
 		@RequestParam(value="pages") Integer numOfPages) {
	 
	 Book book = new Book(title, description, lang, numOfPages);
	 book.setId(id);
	 
     book = bookService.updateBook(book);
     return book;
 }
 
 @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
 }
}
