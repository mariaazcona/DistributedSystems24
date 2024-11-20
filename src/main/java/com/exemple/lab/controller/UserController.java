package com.example.lab.controller;

import com.example.lab.services.UserService;
import com.example.lab.models.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/users")
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get("/")  
    public HttpResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers(); 
        if (users.isEmpty()) {
            return HttpResponse.notFound();  
        }
        return HttpResponse.ok(users);
    }

    @Get("/{id}")
    public HttpResponse<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                          .map(HttpResponse::ok)
                          .orElseGet(() -> HttpResponse.notFound());
    }

    @Post
    public HttpResponse<User> createUser(@Body User user) {
        User createdUser = userService.createUser(user);
        return HttpResponse.created(createdUser);  
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? HttpResponse.noContent() : HttpResponse.notFound();
    }
}




