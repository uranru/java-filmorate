package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.filmorate.service.UniversalService;
import ru.yandex.practicum.filmorate.service.UserService;
import ru.yandex.practicum.filmorate.storage.InMemoryUniversalStorage;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UniversalController<Object> {
    private final Logger log = LoggerFactory.getLogger(UniversalController.class);

    private UniversalService service;

    //@Autowired
    public UniversalController(UniversalService service) { this.service = service; }

    @GetMapping("")
    public List<Object> findAllObjects() {
        List<Object> allObjects = service.findAllObjects();
        log.info("Запрошен список всех объектов. Текущее количество объектов: {}",allObjects.size());
        return allObjects;
    }

    @GetMapping("/{id}")
    public Object findObject(@PathVariable Long id) {
        Object object = (Object) service.findObject(id);
        log.info("Запрошен объект: {}",object);
        return object;
    }

    @PostMapping(value = "")
    public Object createObject(@Valid @RequestBody Object object) {
        service.createObject(object);
        log.info("Добавлен новый объект: {}",object);
        return object;
    }

    @PutMapping(value = "")
    public Object updateObject(@Valid @RequestBody Object object) {
        service.updateObject(object);
        log.info("Изменен объект: {}",object);
        return object;
        //return new ResponseEntity<>(HttpStatus.resolve(202));
    }

}

