package pl.asev.todoapi.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.asev.todoapi.model.ToDoItem;
import pl.asev.todoapi.model.ToDoItemRepository;
import pl.asev.todoapi.model.ToDoListRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ToDoItemController {

    @Autowired
    ToDoItemRepository toDoItemRepository;


    @Autowired
    ObjectMapper objectMapper;

//

        @RequestMapping("/getAll")
    public ResponseEntity getAllItems() throws JsonProcessingException {
        List<ToDoItem> toDoItems = (List<ToDoItem>) toDoItemRepository.findAll();
        return ResponseEntity.ok(objectMapper.writeValueAsString(toDoItems));
    }



    @RequestMapping(value = "/{id}")
    public Optional<ToDoItem> findById(@PathVariable(value = "id", required = true) Long id) {
        return toDoItemRepository.findById(id);
    }


    @RequestMapping(value = "/updatestatus/{id}/{status}")
    public void updateItemStatus(@PathVariable(value = "id", required = true) Long id,
                                 @PathVariable(value = "status", required = true) Boolean status) {


        ToDoItem toDoItem = toDoItemRepository.findById(id).get();
        toDoItem.setStatus(status);
        toDoItemRepository.save(toDoItem);


    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoItem addToDoItem(@RequestBody ToDoItem toDoItem) {
        Date currentDate = new Date();
        toDoItem.setCreatedItem(currentDate);
        return toDoItemRepository.save(toDoItem);


    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoItem updateToDoItem(@RequestBody ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);


    }

    @RequestMapping(value = "/delete/all")
    public void deleteAllItems() {
        toDoItemRepository.deleteAll();
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id", required = true) Long id) {
        toDoItemRepository.deleteById(id);
    }


}