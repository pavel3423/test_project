package by.application.test_project.service.impl;

import by.application.test_project.domain.Execution;
import by.application.test_project.domain.Status;
import by.application.test_project.domain.Task;
import by.application.test_project.domain.Type;
import by.application.test_project.repository.TaskRepository;
import by.application.test_project.service.ExecutionPipeline;
import by.application.test_project.utils.PipelineStatusFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static by.application.test_project.utils.TaskUtil.findTaskByName;

@Service
public class ExecutionPipelineImpl implements ExecutionPipeline {

    private final static Logger log = LoggerFactory.getLogger(ExecutionPipeline.class);

    private TaskRepository taskRepository;

    public ExecutionPipelineImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Execution run(Execution execution) throws Exception {

        List<Task> tasks = execution.getTasks();
        execution.setStatus(Status.IN_PROGRESS);
        execution.setStartTime(new Date());
        execution.getTasks().forEach(task -> task.setStatus(Status.PENDING));

        try {
            runTask(findTaskByName(tasks, "Build"));
            runTask(findTaskByName(tasks, "Test"));

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Task docs = findTaskByName(tasks, "Docs");
            Future future = executor.submit(() -> runTask(docs));

            runTask(findTaskByName(tasks, "Integration Test"));
            runTask(findTaskByName(tasks, "Publish"));
            future.get();
            runTask(findTaskByName(tasks, "Sync"));

            execution.setStatus(Status.COMPLETED);
        } catch (PipelineStatusFailedException e) {
            execution.setStatus(Status.FAILED);
        } finally {
            execution.setEndTime(new Date());
        }

        return execution;
    }

    private void runTask(Task task) {
        task.setStatus(Status.IN_PROGRESS);
        task.setStartTime(new Date());
        System.out.println(task.getName());
        switch (task.getAction()) {
            case PRINT:
                Type.PRINT.run();
                break;
            case RANDOM:
                Type.RANDOM.run();
                task.setStatus(
                        Status.values()[new Random().nextInt(3)]);
                if (task.getStatus().equals(Status.FAILED)) {
                    task.setEndTime(new Date());
                    throw new PipelineStatusFailedException();
                }
                break;
            case COMPLETED:
                Type.COMPLETED.run();
                break;
            case DELAYED:
                Type.DELAYED.run();
                break;
        }

        task.setEndTime(new Date());

        if (task.getStatus().equals(Status.IN_PROGRESS)) {
            task.setStatus(Status.COMPLETED);
        }

        taskRepository.save(task);
    }
}
