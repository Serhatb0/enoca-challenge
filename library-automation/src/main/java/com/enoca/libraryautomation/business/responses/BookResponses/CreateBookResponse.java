package com.enoca.libraryautomation.business.responses.BookResponses;

import com.enoca.libraryautomation.model.Book;

public record CreateBookResponse(int id, String name, String pageCount) {

    public static CreateBookResponse convert(final Book book) {
        return new CreateBookResponse(book.getId(), book.getName(), book.getPageCount());
    }
}
