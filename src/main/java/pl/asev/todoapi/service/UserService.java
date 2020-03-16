package pl.asev.todoapi.service;

import pl.asev.todoapi.model.User;

public interface UserService {
    void save(User user);
    User findByEmail(String email);
}
