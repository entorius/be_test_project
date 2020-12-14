package com.devbridge.sourcery.lectures.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.devbridge.sourcery.lectures.db.MockDB;
import com.devbridge.sourcery.lectures.dto.MovieDto;
import com.devbridge.sourcery.lectures.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping(MovieController.BASE_PATH)
public class MovieController {

  public static final String BASE_PATH = "/api/movies";
  public static final String SINGLE_MOVIE = "/{movieId}";

  private MovieService movieService;

  @GetMapping(SINGLE_MOVIE)
  @ResponseStatus(HttpStatus.OK)
  public MovieDto findMovie(@PathVariable("movieId") UUID movieId) {
    return movieService.findMovie(movieId);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<MovieDto> findMovies(@RequestParam(name = "genre", required = false) Optional<String> genre) {
    if (genre.isPresent()) {
      return movieService.findMovies(genre.get());
    } else {
      return movieService.findMovies();
    }
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void saveMovie(@RequestBody MovieDto movieDto) {
    movieService.saveMovie(movieDto);
  }

  @DeleteMapping(SINGLE_MOVIE)
  @ResponseStatus(HttpStatus.OK)
  public void deleteMovie(@PathVariable("movieId") @Validated  UUID movieId) {
    movieService.deleteMovie(movieId);
  }
}
