package ru.yandex.practicum.filmorate.controller;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private Long i = 0L;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final Map<Long, User> listUsers = new HashMap();

    @GetMapping(value = "/users")
    public Map<Long, User> findAll() {
        log.info("Текущее количество пользователей: {}",listUsers.size());
        return listUsers;
    }

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable Long id) {
        User user = listUsers.get(id);
        log.debug("Запрошен пользователь: {}",user);
        return user;
    }

    @PostMapping(value = "/user")
    public User createUser(@Valid @RequestBody User newUser) {
        Long id = generateId();
        newUser.setId(id);
        if (newUser.getName() == null) {
            newUser.setName(newUser.getLogin());
        }
        listUsers.put(id,newUser);
        log.info("Добавлен новый пользователь: {}", newUser);
        return newUser;
    }

    @PutMapping(value = "/user/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        user.setId(id);
        listUsers.put(id,user);
        log.info("Обновлен пользователь: {}",user);
        return user;
    }

    private Long generateId(){
        i ++;
        return i;
    }

}
