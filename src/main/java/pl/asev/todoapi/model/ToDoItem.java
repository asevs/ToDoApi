package pl.asev.todoapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "item")
@NoArgsConstructor
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_content")
    private String content;
    @Column(name = "item_status")
    private Boolean status;
    @Column(name = "item_created_date")
    private Date createdItem;
    @Column(name = "item_priority")
    private String priority;



}

