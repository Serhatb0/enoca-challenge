package com.enoca.libraryautomation.business.responses.BookResponses;

import com.enoca.libraryautomation.model.Book;

public record UpdateBookResponse(int id, String name, String pageCount) {

    public static UpdateBookResponse convert(final Book book) {
        return new UpdateBookResponse(book.getId(), book.getName(), book.getPageCount());
    }
}
