package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.practicum.filmorate.storage.InMemoryUniversalStorage;

import java.util.List;

public abstract class UniversalService {
    private final InMemoryUniversalStorage storage;

    public UniversalService(InMemoryUniversalStorage storage) {
        this.storage = storage;
    }

    public <Object> List<Object> findAllObjects() {
        return storage.findAllObjects();
    }

    public Object findObject(Long id) {
        return storage.findObject(id);
    }

    public <Object> void createObject(Object object) {
        storage.createObject(object);
    }

    public <Object> void updateObject(Object object) {
        storage.updateObject(object);
    }
}
