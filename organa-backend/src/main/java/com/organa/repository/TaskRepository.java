package com.organa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organa.entity.Project;
import com.organa.entity.Task;
import com.organa.entity.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByProject(Project project);

  List<Task> findByAssignee(User user);

  List<Task> findByProjectAndDeletedFalse(Project project);

  List<Task> findByAssigneeAndDeletedFalse(User user);

  List<Task> findByProjectAndStatus(Project project, String status);
}
