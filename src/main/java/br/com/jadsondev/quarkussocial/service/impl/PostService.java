package br.com.jadsondev.quarkussocial.service.impl;

import br.com.jadsondev.quarkussocial.domain.model.Post;
import br.com.jadsondev.quarkussocial.domain.model.User;
import br.com.jadsondev.quarkussocial.domain.repository.PostRepository;
import br.com.jadsondev.quarkussocial.domain.repository.UserRepository;
import br.com.jadsondev.quarkussocial.dto.CreatePostRequest;
import br.com.jadsondev.quarkussocial.dto.PostResponse;
import br.com.jadsondev.quarkussocial.exception.CustomException;
import br.com.jadsondev.quarkussocial.mapper.PostMapper;
import br.com.jadsondev.quarkussocial.service.IPostService;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PostService implements IPostService {

    private final UserRepository repository;
    private final PostRepository postRepository;
    @Inject
    PostMapper postMapper;

    @Inject
    public PostService(UserRepository repository,PostRepository postRepository ) {
        this.repository = repository;
        this.postRepository = postRepository;

    }

    @Override
    @Transactional
    public void savePost(Long idUser, CreatePostRequest createPostRequest) {

        User user = repository.findById(idUser);

        if(user != null) {
            var novoPost = new Post();
            novoPost.setText(createPostRequest.getText());
            novoPost.setUser(user);
            postRepository.persist(novoPost);
        }else{
            throw new CustomException("User not found!");
        }
    }

    @Override
    @Transactional
    public List<PostResponse> listPost(Long idUser) {

        User user = repository.findById(idUser);

        if(user != null) {
            PanacheQuery<Post> query = postRepository.find("user", Sort.by("dateTime", Sort.Direction.Descending), user);
            List<Post> posts =  query.list();
            return mappertoDTO(posts);

        }else{
            throw new CustomException("User not found!");
        }

    }

    private List<PostResponse> mappertoDTO(List<Post> posts) {

        return posts
                .stream()
                .map(post -> postMapper.toResponse(post))
                .collect(Collectors.toList());
    }
}
