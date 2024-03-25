package br.com.jadsondev.quarkussocial.service;

import br.com.jadsondev.quarkussocial.domain.model.User;
import br.com.jadsondev.quarkussocial.domain.repository.UserRepository;
import br.com.jadsondev.quarkussocial.dto.CreateUserRequest;
import br.com.jadsondev.quarkussocial.service.impl.UserService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@QuarkusTest
public class CreateTest {

    @Inject
    UserService userService;
    @InjectMock
    private UserRepository repository;


    // Should create a new user with the provided name and age
    @Test
    public void test_create_new_user() {
        // Arrange
        CreateUserRequest request = new CreateUserRequest();
        request.setName("John");
        request.setAge(25);
    
        User expectedUser = new User();
        expectedUser.setName("John");
        expectedUser.setAge(25);

        doNothing().when(repository).persist(expectedUser);
    
        // Act
        User actualUser = userService.create(request);
    
        // Assert
        assertNotNull(actualUser);
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getAge(), actualUser.getAge());
    }



}