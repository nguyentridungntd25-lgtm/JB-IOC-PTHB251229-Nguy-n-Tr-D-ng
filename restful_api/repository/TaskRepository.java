package org.example.restful_api.repository;

import org.example.restful_api.model.Task;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> tasks = Arrays.asList(
            new Task(1,"Task 1","Description 1","high",1),
            new Task(2,"Task 2","Description 2","medium",1),
            new Task(3,"Task 3","Description 3","low",2),
            new Task(4,"Task 4","Description 4","high",2),
            new Task(5,"Task 5","Description 5","medium",3),
            new Task(6,"Task 6","Description 6","low",1),
            new Task(7,"Task 7","Description 7","high",3),
            new Task(8,"Task 8","Description 8","medium",2),
            new Task(9,"Task 9","Description 9","low",1),
            new Task(10,"Task 10","Description 10","high",3)
    );

    public List<Task> findAll() {
        return tasks;
    }
    public void save(Task task) {
        tasks.add(task);
    }
}