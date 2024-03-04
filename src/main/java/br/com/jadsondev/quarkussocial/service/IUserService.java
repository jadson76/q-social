package br.com.jadsondev.quarkussocial.service;

import br.com.jadsondev.quarkussocial.domain.model.User;
import br.com.jadsondev.quarkussocial.dto.CreateUserRequest;
import br.com.jadsondev.quarkussocial.exception.CustomException;

import java.util.List;

public interface IUserService {

    User create(CreateUserRequest userRequesst);
    List<User> listAll();
    void delete(Long id) throws CustomException;

    void update(Long id , CreateUserRequest userRequesst) throws CustomException ;


}
