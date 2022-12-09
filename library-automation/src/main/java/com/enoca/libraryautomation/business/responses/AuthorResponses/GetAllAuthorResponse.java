package com.enoca.libraryautomation.business.responses.AuthorResponses;

import java.util.List;

import com.enoca.libraryautomation.business.responses.BookResponses.GetAllBookResponse;
import com.enoca.libraryautomation.model.Author;

public record GetAllAuthorResponse(int authorId, String firstName, String lastName, List<GetAllBookResponse> books) {

    public static GetAllAuthorResponse convert(final Author author) {
        return new GetAllAuthorResponse(author.getId(), author.getFirstName(),
                author.getLastName(),
                author.getBooks().stream().map(GetAllBookResponse::convert).toList());
    }

}
