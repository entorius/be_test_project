package com.devbridge.sourcery.lectures.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.devbridge.sourcery.lectures.dto.MovieDto;
import com.devbridge.sourcery.lectures.exception.NotFoundException;
import com.devbridge.sourcery.lectures.mapper.MovieMapper;
import com.devbridge.sourcery.lectures.model.GenreEntity;
import com.devbridge.sourcery.lectures.model.MovieEntity;
import com.devbridge.sourcery.lectures.repository.GenreRepository;
import com.devbridge.sourcery.lectures.repository.MoviesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MovieService {

  private MoviesRepository moviesRepository;
  private GenreRepository genresRepository;


  public MovieDto findMovie(UUID movieId) {
    MovieEntity movieEntity = moviesRepository.findById(movieId).orElseThrow(() -> new NotFoundException());
    return MovieMapper.map(movieEntity);
  }

  public List<MovieDto> findMovies() {
    List<MovieEntity> movies = moviesRepository.findAll();
    if (movies.isEmpty()) {
      throw new NotFoundException();
    }
    return movies.stream().map(movie -> MovieMapper.map(movie)).collect(Collectors.toList());
  }

  public List<MovieDto> findMovies(String genre) {
    List<MovieEntity> movies = moviesRepository.findByGenre(genre);
    if (movies.isEmpty()) {
      throw new NotFoundException();
    }
    return movies.stream().map(movie -> MovieMapper.map(movie)).collect(Collectors.toList());
  }

  public void saveMovie(MovieDto movieDto) {
    Optional<GenreEntity> genre = genresRepository.findByName(movieDto.getName());
    MovieEntity movieEntity = MovieEntity.builder()
        .id(movieDto.getId())
        .name(movieDto.getName())
        .boxOffice(movieDto.getBoxOffice())
        .genre(genre.orElse(null))
        .releaseDate(movieDto.getReleaseDate())
        .build();
    moviesRepository.save(movieEntity);
  }

  public void deleteMovie(UUID movieId) {
    MovieEntity movieEntity = moviesRepository.findById(movieId).orElseThrow(() -> new NotFoundException());
    moviesRepository.delete(movieEntity);
  }
}
