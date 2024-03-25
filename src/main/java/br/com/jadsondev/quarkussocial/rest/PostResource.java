package br.com.jadsondev.quarkussocial.rest;

import br.com.jadsondev.quarkussocial.domain.model.Post;
import br.com.jadsondev.quarkussocial.dto.CreatePostRequest;
import br.com.jadsondev.quarkussocial.dto.PostResponse;
import br.com.jadsondev.quarkussocial.service.IPostService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    private IPostService service;

    @POST
    public Response savePost(@PathParam("userId") Long userId, CreatePostRequest createPostRequest) {
        service.savePost(userId , createPostRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listPosts(@PathParam("userId") Long userId) {

        List<PostResponse> posts = service.listPost(userId);
        return Response.ok(posts).build();
    }
}
