package com.devbridge.sourcery.lectures.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDto {

  private UUID id;
  @NotNull
  private String name;
  private OffsetDateTime releaseDate;
  private String genre;
  @PositiveOrZero
  private BigDecimal boxOffice;
}


