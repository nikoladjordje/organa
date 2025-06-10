package com.organa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organa.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
  Optional<Organization> findByName(String name);
}
