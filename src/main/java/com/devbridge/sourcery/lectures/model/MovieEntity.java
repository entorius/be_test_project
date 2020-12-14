package com.devbridge.sourcery.lectures.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movies")
public class MovieEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "release_date")
  private OffsetDateTime releaseDate;

  @JoinColumn(name="genre_id", referencedColumnName = "id")
  @ManyToOne
  private GenreEntity genre;

  @Column(name = "box_office")
  private BigDecimal boxOffice;
}
