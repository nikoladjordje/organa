package com.organa.entity;

import java.time.LocalDateTime;

import com.organa.enums.UserOrganizationRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrganization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
  @ManyToOne(optional = false)
  @JoinColumn(name = "organization_id", nullable = false)
  private Organization organization;
  @Enumerated(EnumType.STRING)
  private UserOrganizationRole role;
  private boolean accepted;
  private LocalDateTime invitedAt;
  private LocalDateTime acceptedAt;
  @Column(length = 100, name = "invited_by_email")
  private String invitedByEmail;
}
