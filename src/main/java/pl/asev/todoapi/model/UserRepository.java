package pl.asev.todoapi.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByGoogleId(String googleId);
    User findByEmail(String email);

    User findByEmail(Object email);
}
