package br.com.jadsondev.quarkussocial.service.impl;

import br.com.jadsondev.quarkussocial.domain.model.User;
import br.com.jadsondev.quarkussocial.domain.repository.UserRepository;
import br.com.jadsondev.quarkussocial.dto.CreateUserRequest;
import br.com.jadsondev.quarkussocial.exception.CustomException;
import br.com.jadsondev.quarkussocial.rest.validation.UserValidation;
import br.com.jadsondev.quarkussocial.service.IUserService;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class UserService implements IUserService {

    private final UserRepository repository;
    @Inject
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User create(CreateUserRequest userRequesst) {

      var user = new User();
      user.setName(userRequesst.getName());
      user.setAge(userRequesst.getAge());
      repository.persist(user);
      return user;
    }



    @Transactional
    public List<User> listAll() {
        PanacheQuery<User> query = repository.findAll();
        return query.list();
    }

    @Transactional
    public void delete(Long id)  throws CustomException{
      User user = repository.findById(id);

      if(user != null) {
          repository.deleteById(id);
      }else{
          throw new CustomException("User not found!");
      }

    }

    @Override
    @Transactional
    public void update(Long id, CreateUserRequest userRequesst) throws CustomException {
        User user = repository.findById(id);

        if(user != null) {
            user.setName(userRequesst.getName());
            user.setAge(userRequesst.getAge());
            repository.persist(user);
        }else{
            throw new CustomException("User not found!");
        }
    }
}
