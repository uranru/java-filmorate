package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import ru.yandex.practicum.filmorate.controller.UserController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestFilmController {
/*
    @Test
    public void testGetFilms() throws IOException, InterruptedException{
        String myUri = "http://localhost:8080/films";
        URI uriTest = URI.create(myUri);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uriTest)
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, handler);

        assertEquals( 200,response.statusCode(), "URL /films не доступен" );
    }

    @Test
    public void testPostFilms() throws IOException, InterruptedException {
        String myUri01 = "http://localhost:8080/films";
        URI uriTest01 = URI.create(myUri01);
        String requestBody01 = ("{\"email\":\"test1@test.ru\",\"login\":\"test1\",\"name\":\"test1\",\"birthday\":\"2002-06-28\"}");

        HttpRequest request01 = HttpRequest.newBuilder()
                .uri(uriTest01)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody01))
                .header("Content-type", "application/json")
                .build();

        HttpClient client01 = HttpClient.newHttpClient();
        HttpResponse.BodyHandler<String> handler01 = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response01 = client01.send(request01, handler01);

        assertEquals( 200,response01.statusCode(), "Не проходит запрос на создание фильма" );

        String myUri02 = "http://localhost:8080/films/1";
        URI uriTest02 = URI.create(myUri01);
        HttpRequest request02 = HttpRequest.newBuilder()
                .GET()
                .uri(uriTest02)
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpClient client02 = HttpClient.newHttpClient();
        HttpResponse.BodyHandler<String> handler02 = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response02 = client02.send(request02, handler02);

        assertEquals( 200,response02.statusCode(), "Новый фильм не создался" );
    }

    @Test
    public void testPutFilms() throws IOException, InterruptedException {
        String myUri01 = "http://localhost:8080/films";
        URI uriTest01 = URI.create(myUri01);
        String requestBody01 = ("{\"name\":\"Film\",\"description\":\"New film update decription\",\"releaseDate\":\"1989-04-17\",\"duration\":190}");

        HttpRequest request01 = HttpRequest.newBuilder()
                .uri(uriTest01)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody01))
                .header("Content-type", "application/json")
                .build();

        HttpClient client01 = HttpClient.newHttpClient();
        HttpResponse.BodyHandler<String> handler01 = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response01 = client01.send(request01, handler01);

        assertEquals( 200,response01.statusCode(), "Не проходит запрос на создание фильма" );

        String myUri02 = "http://localhost:8080/films";
        URI uriTest02 = URI.create(myUri02);
        String requestBody02 = ("{\"id\":1,\"name\":\"Film Updated\",\"description\":\"New film update decription\",\"releaseDate\": \"1989-04-17\",\"duration\":190}");

        HttpRequest request02 = HttpRequest.newBuilder()
                .uri(uriTest02)
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody02))
                .header("Content-type", "application/json")
                .build();

        HttpClient client02 = HttpClient.newHttpClient();
        HttpResponse.BodyHandler<String> handler02 = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response02 = client02.send(request02, handler02);

        assertEquals(200, response02.statusCode(), "Не проходит запрос на обновление фильма");
    }
*/
}