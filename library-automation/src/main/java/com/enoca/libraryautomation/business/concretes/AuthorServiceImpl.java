package com.enoca.libraryautomation.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enoca.libraryautomation.business.abstracts.AuthorService;
import com.enoca.libraryautomation.business.requests.PaginatedRequest;
import com.enoca.libraryautomation.business.requests.authorRequests.CreateAuthorRequest;
import com.enoca.libraryautomation.business.requests.authorRequests.UpdateAuthorRequest;
import com.enoca.libraryautomation.business.responses.PaginatedGenericResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.CreateAuthorResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.GetAllAuthorResponse;
import com.enoca.libraryautomation.business.responses.AuthorResponses.UpdateAuthorResponse;
import com.enoca.libraryautomation.model.Author;
import com.enoca.libraryautomation.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public CreateAuthorResponse addAuthor(CreateAuthorRequest createAuthorRequest) {

        Author author = authorRepository.save(Author.builder().firstName(createAuthorRequest.firstName())
                .lastName(createAuthorRequest.lastName()).build());

        return CreateAuthorResponse.convert(author);

    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public PaginatedGenericResponse<GetAllAuthorResponse> getAllAuthor(PaginatedRequest paginatedRequest) {
        Pageable pageable = PageRequest.of(paginatedRequest.page(), paginatedRequest.size());

        Page<Author> pageAuthors = authorRepository.findAll(pageable);

        List<GetAllAuthorResponse> getAllAuthorResponses = pageAuthors.stream()
                .map(GetAllAuthorResponse::convert).collect(Collectors.toList());

        return new PaginatedGenericResponse<>(getAllAuthorResponses,
                pageAuthors.getNumber(), pageAuthors.getSize(), pageAuthors.getTotalElements(),
                pageAuthors.getTotalPages());
    }

    @Override
    public UpdateAuthorResponse updateAuthor(UpdateAuthorRequest updateAuthorRequest) {

        Optional<Author> optionalAuthor = authorRepository.findById(updateAuthorRequest.authorId());

        optionalAuthor.ifPresent(
                author -> {
                    author.setId(updateAuthorRequest.authorId());
                    author.setFirstName(updateAuthorRequest.firstName());
                    author.setLastName(updateAuthorRequest.lastName());
                    authorRepository.save(author);
                });

        return UpdateAuthorResponse.convert(optionalAuthor.get());

    }

    @Override
    public Author findById(int id) {
       return authorRepository.findById(id).get();
    }

}
