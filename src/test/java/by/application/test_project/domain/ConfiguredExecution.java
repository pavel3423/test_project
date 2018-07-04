package by.application.test_project.domain;

import java.util.ArrayList;
import java.util.List;

public class ConfiguredExecution {
    public static Execution getIitialExecution() {
        Execution execution = new Execution();
        List<Task> tasks = new ArrayList<>();
        execution.setTasks(tasks);
        tasks.add(new Task(1, "Build", null, Type.PRINT, null, null, null));
        tasks.add(new Task(2, "Test", null, Type.RANDOM, null, null, null));
        tasks.add(new Task(3, "Integration Test", null, Type.RANDOM, null, null, null));
        tasks.add(new Task(4, "Docs", null, Type.PRINT, null, null, null));
        tasks.add(new Task(5, "Publish", null, Type.RANDOM, null, null, null));
        tasks.add(new Task(6, "Sync", null, Type.PRINT, null, null, null));
        return execution;
    }
}
