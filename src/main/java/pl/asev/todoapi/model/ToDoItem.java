package pl.asev.todoapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "item")
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    Long id;
    @Column(name = "item_content")
    String content;
    @Column(name = "item_status")
    Boolean status;
    @Column(name = "item_created_date")
    Date createdItem;
    @Column(name = "item_priority")
    String priority;


    public ToDoItem() {
    }
}

