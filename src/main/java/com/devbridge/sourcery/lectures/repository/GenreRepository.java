package com.devbridge.sourcery.lectures.repository;

import java.util.Optional;
import java.util.UUID;

import com.devbridge.sourcery.lectures.model.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, UUID> {

  @Query
  Optional<GenreEntity> findByName(@Param("name") String name);
}
