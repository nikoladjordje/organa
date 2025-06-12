package com.organa.dto.request.create;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CreateOrganizationDTO(@Schema(description = "Name of the organization") String name) {
  public CreateOrganizationDTO {
    Objects.requireNonNull(name, "Name must not be null");
  }
}
