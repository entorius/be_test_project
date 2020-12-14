package com.devbridge.sourcery.lectures.mapper;

import javax.swing.text.html.Option;

import java.util.Optional;

import com.devbridge.sourcery.lectures.dto.MovieDto;
import com.devbridge.sourcery.lectures.model.GenreEntity;
import com.devbridge.sourcery.lectures.model.MovieEntity;

public class MovieMapper {

  public static MovieDto map(MovieEntity entity) {
    return MovieDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .boxOffice(entity.getBoxOffice())
        .genre(Optional.ofNullable(entity.getGenre()).map(GenreEntity::getName).orElse(null))
        .releaseDate(entity.getReleaseDate())
        .build();
  }
}
