package by.application.test_project.utils;

import by.application.test_project.domain.Task;

import java.util.List;
import java.util.Optional;

public class TaskUtil {

    public static Task findTaskByName(List<Task> tasks, String taskName) throws IllegalPipelineException {
        Optional<Task> task = tasks.stream().filter(
                item -> item.getName().equals(taskName))
                .findFirst();
        if (task.isPresent()) {
            return task.get();
        } else throw new IllegalPipelineException("Task with name '" + taskName + "' is not present!");
    }
}
