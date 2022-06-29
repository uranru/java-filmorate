package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import ru.yandex.practicum.filmorate.validator.ReleaseDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDate;

@Validated
@Data
public class Film {
    private Long id;
    @NotEmpty(message = "name is not correct")
    private String name;
    @Size(max = 200,message = "description is not correct")
    private String description;
    @ReleaseDate(value = "1895-12-28",message = "releaseDate is not correct")
    private LocalDate releaseDate;
    @Min(value = 0, message = "duration is not correct")
    private Duration duration;
}
