package ru.yandex.practicum.filmorate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.filmorate.model.Film;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("films")
public class FilmController {
    private Long i = 0L;
    private static final Logger log = LoggerFactory.getLogger(FilmController.class);
    private final Map<Long,Film> listFilms = new HashMap<>();

    @GetMapping("")
    public List<Film> findAllFilms() {
        log.debug("Текущее количество фильмов: {}",listFilms.size());
        return viewList();
    }

    @GetMapping("/{id}")
    public Film findFilm(@PathVariable Long id) {
        Film film = listFilms.get(id);
        log.debug("Запрошен фильм: {}",film);
        return film;
    }

    @PostMapping(value = "")
    public Film createFilm(@Valid @RequestBody Film newFilm) {
        Long id = generateId();
        newFilm.setId(id);
        listFilms.put(id,newFilm);
        log.info("Добавлен новый фильм: {}",newFilm);
        return newFilm;
    }

    @PutMapping(value = "")
    public Film updateFilm(@Valid @RequestBody Film film) {
        Long id = film.getId();
        if (listFilms.containsKey(id)) {
            listFilms.put(id,film);
            log.info("Обновлен фильм: {}",film);
            return film;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "film Not Found");
        }
    }

    public List<Film> viewList() {
        List<Film> listView = new ArrayList<>();
        for (Film film : listFilms.values()) {
            listView.add(film);
        }
        return listView;
    }
    private Long generateId(){
        i ++;
        return i;
    }
}

