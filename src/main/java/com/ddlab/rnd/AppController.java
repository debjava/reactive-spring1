package com.ddlab.rnd;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AppController {

  @GetMapping("/movie/{id}")
  public Mono<Movie> getMovieById(@PathVariable("id") Integer id) {
    return Mono.just(new Movie("Polar (2019)", 64));
  }

  //  @GetMapping(
  //      path = "/allbooks11",
  //      produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
  @GetMapping(
      path = "/allMovies",
      produces = {MediaType.APPLICATION_STREAM_JSON_VALUE})
  public Flux<Movie> getAllBooks11() {
    List<Movie> movie = new ArrayList<>();
    movie.add(new Movie("Polar (2019)", 64));
    movie.add(new Movie("Iron Man (2008)", 79));
    movie.add(new Movie("The Shawshank Redemption (1994)", 93));
    movie.add(new Movie("Forrest Gump (1994)", 83));
    movie.add(new Movie("Glass (2019)", 70));

    return Flux.fromIterable(movie).delayElements(Duration.ofSeconds(2));
  }
}
