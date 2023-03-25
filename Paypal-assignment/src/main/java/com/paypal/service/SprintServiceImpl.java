package com.paypal.service;

import com.paypal.entity.Sprint;
import com.paypal.entity.Task;
import com.paypal.entity.TaskStatus;
import com.paypal.entity.User;
import com.paypal.exception.ResourceNotFoundException;
import com.paypal.repository.SprintRepository;
import com.paypal.repository.TaskRepository;
import com.paypal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Sprint createSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public Sprint addTaskToSprint(Integer sprintId, Task task) throws ResourceNotFoundException {
        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id " + sprintId));
        task.setSprint(sprint);
        taskRepository.save(task);
        return sprint;
    }

    @Override
    public Sprint changeAssignee(Integer taskId, User user) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));
        task.setAssignee(user);
        taskRepository.save(task);
        return null;
    }

    @Override
    public Sprint changeStatus(Integer taskId, TaskStatus status) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));
        task.setStatus(status);
        taskRepository.save(task);
        return null;
    }

    @Override
    public List<Task> getAllTasksBySprintId(Integer sprintId) throws ResourceNotFoundException {
        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new ResourceNotFoundException("Sprint not found with id " + sprintId));
        return sprint.getTasks();
    }

    @Override
    public List<Task> getAllTasksByAssigneeId(Integer assigneeId) throws ResourceNotFoundException {
        User user = userRepository.findById(assigneeId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + assigneeId));
        return user.getTasks();
    }

    @Override
    public List<Sprint> getAllSprints() {

            List<Sprint> sprints = sprintRepository.findAll();
            return sprints;
    }

    @Override
    public List<Task> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

}
