package br.com.jadsondev.quarkussocial.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        List<String> errorMessages = new ArrayList<>();
        for (ConstraintViolation<?> violation : violations) {
            errorMessages.add(violation.getMessage());
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Collections.singletonMap("errors", errorMessages))
                .build();
    }
}
