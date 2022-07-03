package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UniController<Object> {
    private Long i = 0L;
    private static final Logger log = LoggerFactory.getLogger(UniController.class);
    private Map<Long,Object> listObjects = new HashMap<>();

    @GetMapping("")
    public List<Object> findAllObjects() {
        log.debug("Текущее количество объектов: {}",listObjects.size());
        return viewListObjects();
    }

    @GetMapping("/{id}")
    public Object findObject(@PathVariable Long id) {
        Object object = listObjects.get(id);
        log.debug("Запрошен объект: {}",object);
        return object;
    }

    @PostMapping(value = "")
    public Object createObject(@Valid @RequestBody Object newObject) {
        Long id = generateId();
        setId(newObject,id);
        checkObject(newObject);
        listObjects.put(id,newObject);
        log.info("Добавлен новый объект: {}",newObject);
        return newObject;
    }

    @PutMapping(value = "")
    public Object updateFilm(@Valid @RequestBody Object object) {
        Long id = getId(object);
        if (listObjects.containsKey(id)) {
            listObjects.put(id,object);
            log.info("Обновлен объект: {}",object);
            return object;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Object not Found");
        }
    }

    public List<Object> viewListObjects() {
        List<Object> listView = new ArrayList<>();
        for (Object object : listObjects.values()) {
            listView.add(object);
        }
        return listView;
    }
    private Long generateId(){
        i ++;
        return i;
    }

    abstract void setId (Object object,Long id);

    abstract void checkObject (Object object);

    abstract Long getId (Object object);

}

