package com.example.springjdbc.controller;


import com.example.springjdbc.data.repository.BookRepository;
import com.example.springjdbc.dto.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrudController {

    private final BookRepository bookRepository;

    @PostMapping
    public Long createBook(@RequestBody Book book) {
        return bookRepository.createBook(book);
    }

    @GetMapping
    public Book getBookById(@RequestParam Long id) {
        return bookRepository.getBookById(id);
    }

    @PutMapping
    public void editBook(@RequestBody Book book) {
         bookRepository.editBook(book);
    }

    @DeleteMapping
    public void deleteBookById(@RequestParam Long id)  {
        bookRepository.deleteBook(id);
    }

}
