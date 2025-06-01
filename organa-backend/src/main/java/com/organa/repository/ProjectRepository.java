package com.organa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organa.entity.Organization;
import com.organa.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
  List<Project> findByOrganization(Organization organization);

  List<Project> findByOrganizationAndDeletedFalse(Organization organization);

  Optional<Project> findByNameIgnoreCase(String name);
}
