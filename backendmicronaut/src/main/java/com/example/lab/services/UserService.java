package com.example.lab.services;

import com.example.lab.models.User;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserService {

    private final List<User> users = new ArrayList<>();  // Simula la base de datos en memoria

    // Simula la creación de un usuario
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        // Aquí deberías recuperar los usuarios desde una base de datos o una fuente de datos.
        // En este caso, devolvemos una lista de ejemplo para fines demostrativos.
        List<User> users = new ArrayList<>();
        users.add(new User("1", "John Doe", "jd@gmail.com"));
        users.add(new User("2", "Jane Doe", "exemple@gmail.com"));
        return users;
    }


    // Simula obtener un usuario por ID
    public Optional<User> getUserById(String id) {
        return users.stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst();
    }

    // Simula eliminar un usuario
    public boolean deleteUser(String id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}

