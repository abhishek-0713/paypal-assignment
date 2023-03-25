package com.paypal.controller;

import com.paypal.entity.Sprint;
import com.paypal.entity.Task;
import com.paypal.entity.TaskStatus;
import com.paypal.entity.User;
import com.paypal.exception.ResourceNotFoundException;
import com.paypal.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paypal")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping("/sprint")
    public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint) {

        Sprint newSprint = sprintService.createSprint(sprint);
        return new ResponseEntity<>(newSprint, HttpStatus.CREATED);

    }

    @PutMapping("/task")
    public ResponseEntity<?> addTaskToSprint(@RequestParam Integer sprintId, @RequestBody Task task) throws ResourceNotFoundException {

        Sprint sprint = sprintService.addTaskToSprint(sprintId, task);
        return new ResponseEntity<>(sprint, HttpStatus.ACCEPTED);
    }

    @PutMapping("/change/assignee")
    public ResponseEntity<?> changeAssignee(@RequestParam Integer taskId, @RequestBody User user) throws ResourceNotFoundException {

        Sprint sprint = sprintService.changeAssignee(taskId, user);
        return new ResponseEntity<>(sprint, HttpStatus.ACCEPTED);

    }

    @PutMapping("/task/changeStatus")
    public ResponseEntity<?> changeStatus(@RequestParam Integer taskId, @RequestParam TaskStatus status) throws ResourceNotFoundException {

        Sprint sprint = sprintService.changeStatus(taskId, status);
        return new ResponseEntity<>(sprint, HttpStatus.ACCEPTED);

    }

    @GetMapping("/tasks/sprintId")
    public  ResponseEntity<List<Task>> getAllTasksBySprintId(@RequestParam Integer sprintId) throws ResourceNotFoundException{

        List<Task> tasks = sprintService.getAllTasksBySprintId(sprintId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);

    }

    @GetMapping("/tasks/assigneeId")
    public  ResponseEntity<List<Task>> getAllTasksByAssigneeId(@RequestParam Integer assigneeId) throws ResourceNotFoundException{

        List<Task> tasks = sprintService.getAllTasksByAssigneeId(assigneeId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);

    }


}
