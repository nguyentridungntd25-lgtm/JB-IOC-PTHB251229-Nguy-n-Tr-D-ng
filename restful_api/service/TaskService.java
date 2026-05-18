package org.example.restful_api.service;

import org.example.restful_api.model.Task;
import org.example.restful_api.model.User;
import org.example.restful_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository,
                       UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public boolean createTask(Task task) {

        User user = userService.findUserById(task.getAssignedTo());

        if (user == null) {
            return false;
        }

        taskRepository.save(task);
        return true;
    }
}