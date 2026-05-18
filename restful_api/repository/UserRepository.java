package org.example.restful_api.repository;

import org.example.restful_api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "dung", "dung@gmail.com", "admin"));
        users.add(new User(2, "an", "an@gmail.com", "user"));
        users.add(new User(3, "khanh", "khanh@gmail.com", "user"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}