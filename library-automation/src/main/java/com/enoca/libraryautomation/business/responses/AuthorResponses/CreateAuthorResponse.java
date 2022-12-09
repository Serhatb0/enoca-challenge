package com.enoca.libraryautomation.business.responses.AuthorResponses;

import com.enoca.libraryautomation.model.Author;

public record CreateAuthorResponse(int authorId, String firstName, String lastName) {
    
    public static CreateAuthorResponse convert(final Author author) {
        return new CreateAuthorResponse(author.getId(), author.getFirstName(), author.getLastName());
    }
}
