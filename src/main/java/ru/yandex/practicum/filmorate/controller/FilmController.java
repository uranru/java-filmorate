package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FilmController {
    private Long i = 0L;
    private static final Logger log = LoggerFactory.getLogger(FilmController.class);
    private final Map<Long,Film> listFilms = new HashMap<>();

    @GetMapping("/films")
    public Map<Long,Film> findAllFilms() {
        log.debug("Текущее количество фильмов: {}",listFilms.size());
        return listFilms;
    }

    @GetMapping("/film/{id}")
    public Film findFilm(@PathVariable Long id) {
        Film film = listFilms.get(id);
        log.debug("Запрошен фильм: {}",film);
        return film;
    }

    @PostMapping(value = "/film")
    public Film createFilm(@Valid @RequestBody Film newFilm) {
        Long id = generateId();
        newFilm.setId(id);
        listFilms.put(id,newFilm);
        log.info("Добавлен новый фильм: {}",newFilm);
        return newFilm;
    }

    @PutMapping(value = "/film/{id}")
    public Film updateFilm(@PathVariable Long id, @Valid @RequestBody Film film) {
        film.setId(id);
        listFilms.put(id,film);
        log.info("Обновлен фильм: {}",film);
        return film;
    }

    private Long generateId(){
        i ++;
        return i;
    }
}

