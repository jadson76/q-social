package br.com.jadsondev.quarkussocial.rest;

import br.com.jadsondev.quarkussocial.domain.model.User;
import br.com.jadsondev.quarkussocial.dto.CreateUserRequest;
import br.com.jadsondev.quarkussocial.exception.CustomException;
import br.com.jadsondev.quarkussocial.rest.validation.UserValidation;
import br.com.jadsondev.quarkussocial.service.IUserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private IUserService service;
    @Inject
    private UserValidation validation;

    @POST
    public Response createUser( CreateUserRequest userRequest) {

        validation.validate(userRequest);

        User user = service.create(userRequest);

        return Response
                .status(Response.Status.CREATED.getStatusCode())
                .entity(user)
                .build();
    }
    @GET
    public Response listAllUsers() {
        return Response.ok(service.listAll()).build();
    }
    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id)  throws CustomException {
        service.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") Long id,CreateUserRequest userData) throws CustomException    {

        validation.validate(userData);

        service.update(id,userData);

        return Response.noContent().build();
    }
}
