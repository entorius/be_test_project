package com.devbridge.sourcery.lectures.db;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.devbridge.sourcery.lectures.dto.MovieDto;

public class MockDB {

  private static Map<UUID, MovieDto> movieDtoMap = new HashMap<>();

  public static void saveMovie(MovieDto movieDto) {
    movieDtoMap.put(movieDto.getId(), movieDto);
  }

  public static MovieDto findMovie(UUID ID) {
    return movieDtoMap.get(ID);
  }

  public static List<MovieDto> findMovies() {
    return movieDtoMap.values().stream().collect(Collectors.toList());
  }

  public static void deleteMovie(UUID id) {
    movieDtoMap.remove(id);
  }
}
