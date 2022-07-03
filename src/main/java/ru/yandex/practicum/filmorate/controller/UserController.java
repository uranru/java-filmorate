package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.User;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController extends UniController<User>{
    protected final Long i = 0L;
    protected static final Logger log = LoggerFactory.getLogger(UserController.class);
    protected final Map<Long,Object> listObjects = new HashMap<>();

    @Override
    protected void setId(User user, Long id) {
        user.setId(id);
    }

    @Override
    protected Long getId(User user) {
        return user.getId();
    }

    @Override
    protected void checkObject (User user){
        if (user.getName() == null || user.getName().isEmpty()) {
            user.setName(user.getLogin());
        }
    }
}
