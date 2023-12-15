package com.dataprovider.controller;

import com.dataprovider.entity.Book;
import com.dataprovider.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ReactController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books-object")
    public List<Book> booksobj() {
        return bookRepository.findAll();
    }

    @GetMapping("/books-body")
    @ResponseBody
    public List<Book> booksbody() {
        return bookRepository.findAll();
    }

    @GetMapping("/books-resp")
    public ResponseEntity<List<Book>> booksresp() {
        List<Book> list = bookRepository.findAll();
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("sign", "no-value");
        headers.add("contract", "ready");
        return new ResponseEntity<>( list, headers, HttpStatus.OK );
    }

}
