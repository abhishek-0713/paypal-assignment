package com.paypal.service;

import com.paypal.entity.Sprint;
import com.paypal.entity.Task;
import com.paypal.entity.TaskStatus;
import com.paypal.entity.User;
import com.paypal.exception.ResourceNotFoundException;

import java.util.List;

public interface SprintService {
    Sprint createSprint(Sprint sprint);

    Sprint addTaskToSprint(Integer sprintId, Task task) throws ResourceNotFoundException;

    Sprint changeAssignee(Integer taskId, User user) throws ResourceNotFoundException;

    Sprint changeStatus(Integer taskId, TaskStatus status) throws ResourceNotFoundException;

    List<Task> getAllTasksBySprintId(Integer sprintId) throws ResourceNotFoundException;

    List<Task> getAllTasksByAssigneeId(Integer assigneeId) throws ResourceNotFoundException;

    List<Sprint> getAllSprints();

    List<Task> getAllTasks();
}
