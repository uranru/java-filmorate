package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("films")
public class FilmController extends UniController<Film>{
    protected final Long i = 0L;
    protected static final Logger log = LoggerFactory.getLogger(FilmController.class);
    protected final Map<Long,Object> listObjects = new HashMap<>();

    @Override
    protected void setId(Film film, Long id) {
        film.setId(id);
    }

    @Override
    protected Long getId(Film film) {
        return film.getId();
    }

    @Override
    void checkObject(Film film) {
    }
}

