package com.organa.dto.request.create;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateOrganizationDTO(@Schema(description = "Name of the organization") @NotBlank String name) {
}
