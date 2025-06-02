package com.organa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

@Entity
@Table(name = "activity_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;
  @ManyToOne
  @JoinColumn(name = "task_id")
  private Task task;
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id")
  private User user;
  @Column(length = 255, nullable = false)
  private String action;
  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime timestamp;

}
