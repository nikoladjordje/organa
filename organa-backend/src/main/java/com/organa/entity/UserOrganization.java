package com.organa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// CREATE TABLE user_organization (
//   id SERIAL PRIMARY KEY,
//   user_id INT NOT NULL REFERENCES users(id),
//   organization_id INT NOT NULL REFERENCES organizations(id),
//   role VARCHAR(50),
//   accepted BOOLEAN DEFAULT FALSE,
//   invited_at NOT NULL TIMESTAMP,
//   accepted_at NOT NULL TIMESTAMP,
//   invited_by_email VARCHAR(100)
// );
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
  @Column(length = 50)
  private String role;
  private boolean accepted;
  private LocalDateTime invitedAt;
  private LocalDateTime acceptedAt;
  @Column(length = 100, name = "invited_by_email")
  private String invitedByEmail;
}
