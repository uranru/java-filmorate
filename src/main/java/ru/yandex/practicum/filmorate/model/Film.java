package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import ru.yandex.practicum.filmorate.validator.ReleaseDate;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Validated
@Getter @Setter
public class Film {
    private Long id;
    @NotEmpty(message = "name is not correct")
    private String name;
    @Size(max = 200,message = "description is not correct")
    private String description;
    @ReleaseDate(value = "1895-12-28",message = "releaseDate is not correct")
    private LocalDate releaseDate;
    @Positive(message = "duration is not correct")
    private Long duration;
}
