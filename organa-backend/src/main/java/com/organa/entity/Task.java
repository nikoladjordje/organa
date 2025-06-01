package com.organa.entity;

import java.time.LocalDateTime;

import com.organa.enums.TaskPriority;
import com.organa.enums.TaskStatus;

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
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional = false)
  @JoinColumn(name = "project_id", nullable = false)
  private Project project;
  @ManyToOne
  @JoinColumn(name = "assignee_id")
  private User assignee;
  @Column(length = 150, nullable = false)
  private String title;
  @Column(columnDefinition = "TEXT")
  private String description;
  @Column(length = 50)
  @Enumerated(EnumType.STRING)
  private TaskStatus status;
  private LocalDateTime deadline;
  @Column(length = 50)
  @Enumerated(EnumType.STRING)
  private TaskPriority priority;
  @Column(nullable = false)
  private Boolean deleted = false;

}
