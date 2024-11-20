package com.example.lab.controller;

import com.example.lab.services.UserService;
import com.example.lab.models.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/users")  // Ruta base para este controlador
public class UserController {

    private final UserService userService;

    // Inyección de dependencia de UserService
    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get("/")  // El controlador responde a la ruta /users
    public HttpResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();  // Llama al servicio para obtener todos los usuarios
        if (users.isEmpty()) {
            return HttpResponse.notFound();  // Si no hay usuarios, devuelve un 404
        }
        return HttpResponse.ok(users);  // Devuelve una respuesta 200 con la lista de usuarios
    }


    // Endpoint para obtener un usuario por ID
    @Get("/{id}")
    public HttpResponse<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                          .map(HttpResponse::ok)
                          .orElseGet(() -> HttpResponse.notFound());
    }

    // Endpoint para crear un nuevo usuario
    @Post
    public HttpResponse<User> createUser(@Body User user) {
        User createdUser = userService.createUser(user);
        return HttpResponse.created(createdUser);  // Retorna el usuario creado con código 201
    }

    // Endpoint para eliminar un usuario por ID
    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? HttpResponse.noContent() : HttpResponse.notFound();
    }
}




