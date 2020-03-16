package pl.asev.todoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Column(name = "list_status")
    private Boolean status;
    @Column(name = "list_update_date")
    private Date updateList;
    @Column(name = "list_title")
    private String title;

    @OneToMany
    @JoinTable(name = "to_do_list", joinColumns = @JoinColumn(name = "list_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ToDoItem> toDoItems;


}
