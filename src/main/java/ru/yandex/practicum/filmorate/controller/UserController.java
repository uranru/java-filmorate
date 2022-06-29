package ru.yandex.practicum.filmorate.controller;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {
    private Long i = 0L;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final Map<Long, User> listUsers = new HashMap();

    @GetMapping(value = "")
    public List<User> findAll() {
        log.info("Текущее количество пользователей: {}",listUsers.size());
        List<User> listView = new ArrayList<>();
        return viewList();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id) {
        User user = listUsers.get(id);
        log.debug("Запрошен пользователь: {}",user);
        return user;
    }

    @PostMapping(value = "")
    public User createUser(@Valid @RequestBody User newUser) {
        Long id = generateId();
        newUser.setId(id);
        if (newUser.getName() == null || newUser.getName().isEmpty()) {
            newUser.setName(newUser.getLogin());
        }
        listUsers.put(id,newUser);
        log.info("Добавлен новый пользователь: {}", newUser);
        return newUser;
    }

    @PutMapping(value = "")
    public User updateUser(@Valid @RequestBody User user) {
        Long id = user.getId();
        if (listUsers.containsKey(id)) {
            listUsers.put(id,user);
            log.info("Обновлен пользователь: {}",user);
            return user;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "user Not Found");
        }

    }
    public List<User> viewList() {
        List<User> listView = new ArrayList<>();
        for (User user : listUsers.values()) {
            listView.add(user);
        }
        return listView;
    }

    private Long generateId(){
        i ++;
        return i;
    }

}
