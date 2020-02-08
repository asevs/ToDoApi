package pl.asev.todoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "to_do_list")
@NoArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "list_id")
    private Long id;
    @Column(name = "user_id")
    private Long user;
    @Column(name = "list_status")
    private Boolean status;
    @Column(name = "lisr_created_date")
    private Date createdItem;


}
