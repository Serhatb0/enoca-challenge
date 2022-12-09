package com.enoca.libraryautomation.business.responses.BookResponses;

import com.enoca.libraryautomation.model.Book;

public record GetAllBookResponse(int id, String name, String pageCount, String authorName) {

    public static GetAllBookResponse convert(final Book book) {
        return new GetAllBookResponse(book.getId(), book.getName(),
                book.getPageCount(),
                book.getAuthor().getFirstName());
    }

}
