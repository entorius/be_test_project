package com.devbridge.sourcery.lectures.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.devbridge.sourcery.lectures.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<MovieEntity, UUID>{

  @Query
  Optional<MovieEntity> findByName(@Param("name") String name);

  @Query("select m from movies m join m.genre g where g.name = :genre")
  List<MovieEntity> findByGenre(@Param("genre") String genre);
}
