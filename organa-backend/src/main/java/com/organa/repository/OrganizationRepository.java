package com.organa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organa.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
  Optional<Organization> findByName(String name);
}
