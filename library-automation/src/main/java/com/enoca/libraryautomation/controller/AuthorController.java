package com.enoca.libraryautomation.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.libraryautomation.business.abstracts.AuthorService;
import com.enoca.libraryautomation.business.requests.PaginatedRequest;
import com.enoca.libraryautomation.business.requests.authorRequests.CreateAuthorRequest;
import com.enoca.libraryautomation.business.requests.authorRequests.UpdateAuthorRequest;
import com.enoca.libraryautomation.business.responses.PaginatedGenericResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.CreateAuthorResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.GetAllAuthorResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.UpdateAuthorResponse;

@RestController
@RequestMapping("/api")
public class AuthorController {
    
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    public CreateAuthorResponse addBook(@RequestBody CreateAuthorRequest createAuthorRequest) {
        return authorService.addAuthor(createAuthorRequest);
    }

    @GetMapping("/authors")
    public PaginatedGenericResponse<GetAllAuthorResponse> getAllBook(@RequestBody PaginatedRequest paginatedRequest) {
        return authorService.getAllAuthor(paginatedRequest);
    }

    @PutMapping("/authors")
    public UpdateAuthorResponse updateBook(@RequestBody UpdateAuthorRequest updateAuthorRequest) {
        return authorService.updateAuthor(updateAuthorRequest);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteBook(@PathVariable int id) {
        this.authorService.deleteAuthor(id);
    }


}
