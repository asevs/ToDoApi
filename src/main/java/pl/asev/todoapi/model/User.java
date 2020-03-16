package pl.asev.todoapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "google_id")
    private String googleId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_last_login")
    private LocalDateTime lastLoginDate;
    @Column(name = "created_user_date")
    private LocalDateTime createdUserDate;
    @Column(name = "photo")
    private String photo;
    @Column(name = "login_type")
    private UserLoginType loginType;


    @ManyToMany()
    @JoinTable(name = "user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "list_id"))
    private List<ToDoList> toDoLists;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
