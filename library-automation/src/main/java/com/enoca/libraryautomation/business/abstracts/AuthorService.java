package com.enoca.libraryautomation.business.abstracts;

import com.enoca.libraryautomation.business.requests.PaginatedRequest;
import com.enoca.libraryautomation.business.requests.authorRequests.CreateAuthorRequest;
import com.enoca.libraryautomation.business.requests.authorRequests.UpdateAuthorRequest;
import com.enoca.libraryautomation.business.responses.PaginatedGenericResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.CreateAuthorResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.GetAllAuthorResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.UpdateAuthorResponse;
import com.enoca.libraryautomation.model.Author;

public interface AuthorService {
    
    public PaginatedGenericResponse<GetAllAuthorResponse> getAllAuthor(PaginatedRequest paginatedRequest);

    public CreateAuthorResponse addAuthor(CreateAuthorRequest createAuthorRequest);

    public UpdateAuthorResponse updateAuthor(UpdateAuthorRequest updateAuthorRequest);

    public void deleteAuthor(int id);

    public Author findById(int id);
}
