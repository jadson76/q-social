package br.com.jadsondev.quarkussocial.mapper;

import br.com.jadsondev.quarkussocial.domain.model.Post;
import br.com.jadsondev.quarkussocial.dto.PostResponse;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.List;

@ApplicationScoped
public class PostMapper {
    public PostResponse toResponse(Post post){
        return new PostResponse(post.getText(),post.getDataTime());
    }


}
