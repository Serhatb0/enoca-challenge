package com.enoca.libraryautomation.business.abstracts;


import com.enoca.libraryautomation.business.requests.PaginatedRequest;
import com.enoca.libraryautomation.business.requests.bookRequests.CreateBookRequest;
import com.enoca.libraryautomation.business.requests.bookRequests.UpdateBookRequest;
import com.enoca.libraryautomation.business.responses.PaginatedGenericResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.CreateBookResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.GetAllBookResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.UpdateBookResponse;

public interface BookService {

    public  PaginatedGenericResponse<GetAllBookResponse> getAllBooks(PaginatedRequest paginatedRequest);

    public CreateBookResponse addBook(CreateBookRequest createBookRequest);

    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest);

    public void deleteBook(int id);
}
