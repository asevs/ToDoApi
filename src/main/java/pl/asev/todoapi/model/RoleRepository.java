package pl.asev.todoapi.model;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByRole(String role);
}
