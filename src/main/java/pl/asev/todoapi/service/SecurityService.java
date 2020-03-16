package pl.asev.todoapi.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}