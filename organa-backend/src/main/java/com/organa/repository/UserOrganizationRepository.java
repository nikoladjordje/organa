package com.organa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organa.entity.Organization;
import com.organa.entity.User;
import com.organa.entity.UserOrganization;

@Repository
public interface UserOrganizationRepository extends JpaRepository<UserOrganization, Long> {
  List<UserOrganization> findByUser(User user);

  List<UserOrganization> findByOrganization(Organization organization);

  Optional<UserOrganization> findByUserAndOrganization(User user, Organization organization);
}
