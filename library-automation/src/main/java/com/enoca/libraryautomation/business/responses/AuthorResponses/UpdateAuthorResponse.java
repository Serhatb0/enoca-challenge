package com.enoca.libraryautomation.business.responses.AuthorResponses;

import com.enoca.libraryautomation.model.Author;

public record UpdateAuthorResponse(int authorId, String firstName, String lastName) {

    public static UpdateAuthorResponse convert(final Author author) {
        return new UpdateAuthorResponse(author.getId(), author.getFirstName(), author.getLastName());
    }
}
