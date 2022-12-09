package com.enoca.libraryautomation.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.libraryautomation.business.abstracts.BookService;
import com.enoca.libraryautomation.business.requests.PaginatedRequest;
import com.enoca.libraryautomation.business.requests.bookRequests.CreateBookRequest;
import com.enoca.libraryautomation.business.requests.bookRequests.UpdateBookRequest;
import com.enoca.libraryautomation.business.responses.PaginatedGenericResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.CreateBookResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.GetAllBookResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.UpdateBookResponse;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public CreateBookResponse addBook(@RequestBody CreateBookRequest createBookRequest) {
        return bookService.addBook(createBookRequest);
    }

    @GetMapping("/books")
    public PaginatedGenericResponse<GetAllBookResponse> getAllBook(@RequestBody PaginatedRequest paginatedRequest) {
        return bookService.getAllBooks(paginatedRequest);
    }

    @PutMapping("/books")
    public UpdateBookResponse updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        return bookService.updateBook(updateBookRequest);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        this.bookService.deleteBook(id);
    }

}
