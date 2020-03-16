package pl.asev.todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.asev.todoapi.model.User;
import pl.asev.todoapi.model.UserRepository;

import java.time.LocalDateTime;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/checkUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String checkLogin(@RequestBody User user) {
        String result = "";
        User user1 = userRepository.findByEmail(user.getEmail());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword()))
                result = "logged";
            else
                result = "badpassword";
        } else
            return result = "bademail";
    
        return result;
    }


    @RequestMapping(value = "/addBasicUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User user(@RequestBody User user) {

        User user1 = userRepository.findByEmail(user.getEmail());
        if (user1 == null) {
            LocalDateTime localDateTime = LocalDateTime.now();
            user.setCreatedUserDate(localDateTime);
            return userRepository.save(user);
        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            user1.setLastLoginDate(localDateTime);
            return userRepository.save(user1);
        }
    }


}
