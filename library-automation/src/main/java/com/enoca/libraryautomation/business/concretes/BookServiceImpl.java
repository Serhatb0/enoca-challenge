package com.enoca.libraryautomation.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enoca.libraryautomation.business.abstracts.AuthorService;
import com.enoca.libraryautomation.business.abstracts.BookService;
import com.enoca.libraryautomation.business.requests.PaginatedRequest;
import com.enoca.libraryautomation.business.requests.bookRequests.CreateBookRequest;
import com.enoca.libraryautomation.business.requests.bookRequests.UpdateBookRequest;
import com.enoca.libraryautomation.business.responses.PaginatedGenericResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.CreateBookResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.GetAllBookResponse;
import com.enoca.libraryautomation.business.responses.BookResponses.UpdateBookResponse;
import com.enoca.libraryautomation.model.Author;
import com.enoca.libraryautomation.model.Book;
import com.enoca.libraryautomation.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public PaginatedGenericResponse<GetAllBookResponse> getAllBooks(PaginatedRequest paginatedRequest) {
        Pageable pageable = PageRequest.of(paginatedRequest.page(), paginatedRequest.size());

        Page<Book> pageBook = bookRepository.findAll(pageable);

        List<GetAllBookResponse> getAllBookResponses = pageBook.stream()
                .map(GetAllBookResponse::convert).collect(Collectors.toList());

        return new PaginatedGenericResponse<>(getAllBookResponses,
                pageBook.getNumber(), pageBook.getSize(), pageBook.getTotalElements(),
                pageBook.getTotalPages());
    }

    @Override
    public CreateBookResponse addBook(CreateBookRequest createBookRequest) {

        Author author = authorService.findById(createBookRequest.authorId());

        Book book = bookRepository.save(Book.builder().name(createBookRequest.name())
                .pageCount(createBookRequest.pageCount()).author(author).build());

        return CreateBookResponse.convert(book);

    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest) {

        Author author = authorService.findById(updateBookRequest.authorId());

        Optional<Book> optionalBook = bookRepository.findById(updateBookRequest.bookId());

        optionalBook.ifPresent(book -> {
            book.setId(updateBookRequest.bookId());
            book.setName(updateBookRequest.name());
            book.setPageCount(updateBookRequest.pageCount());
            book.setAuthor(author);
            bookRepository.save(book);
        });

        return UpdateBookResponse.convert(optionalBook.get());

    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);

    }

}
