package br.com.jadsondev.quarkussocial.service;

import br.com.jadsondev.quarkussocial.domain.model.Post;
import br.com.jadsondev.quarkussocial.dto.CreatePostRequest;
import br.com.jadsondev.quarkussocial.dto.PostResponse;

import java.util.List;

public interface IPostService {

    void savePost(Long idUser, CreatePostRequest createPostRequest);

    List<PostResponse> listPost(Long idUser);
}
