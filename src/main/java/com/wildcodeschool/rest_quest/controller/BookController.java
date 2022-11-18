package com.wildcodeschool.rest_quest.controller;

import com.wildcodeschool.rest_quest.entity.Book;
import com.wildcodeschool.rest_quest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> index(){

        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable Long id) {

        return bookRepository.findById(id).get();
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {

        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getDescription());
        return bookRepository.save(bookToUpdate);
    }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable Long id) {

        bookRepository.deleteById(id);
        return true;
    }
}
