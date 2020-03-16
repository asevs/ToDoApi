package pl.asev.todoapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.asev.todoapi.model.ToDoList;
import pl.asev.todoapi.model.ToDoListRepository;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/list")
public class ToDoListController {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/getAll")
    public ResponseEntity getAllLists() throws JsonProcessingException {
        List<ToDoList> toDoLists = (List<ToDoList>) toDoListRepository.findAll();

        return ResponseEntity.ok(objectMapper.writeValueAsString(toDoLists));

    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoList addToDoList(@RequestBody ToDoList toDoList) {
        Date currentDate = new Date();
        toDoList.setUpdateList(currentDate);

        return toDoListRepository.save(toDoList);

    }


}
