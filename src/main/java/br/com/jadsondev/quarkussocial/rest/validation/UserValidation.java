package br.com.jadsondev.quarkussocial.rest.validation;

import br.com.jadsondev.quarkussocial.dto.CreateUserRequest;
import br.com.jadsondev.quarkussocial.exception.ResponseError;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@ApplicationScoped
public class UserValidation {

    private Validator validator;

    @Inject
    public UserValidation(Validator validator) {
        this.validator = validator;
    }

    public void validate(CreateUserRequest userRequesst) {
        Set<ConstraintViolation<CreateUserRequest>> violations = validator.validate(userRequesst);

        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }



    }
}
