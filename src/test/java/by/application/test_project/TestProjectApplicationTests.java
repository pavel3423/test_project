package by.application.test_project;

import by.application.test_project.domain.ConfiguredExecution;
import by.application.test_project.domain.Execution;
import by.application.test_project.domain.Status;
import by.application.test_project.domain.Task;
import by.application.test_project.repository.TaskRepositoryMock;
import by.application.test_project.service.impl.ExecutionPipelineImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProjectApplicationTests {

    @Test
    public void ExecutionPipelineRunTest() throws Exception {
        ExecutionPipelineImpl executionPipeline = new ExecutionPipelineImpl(new TaskRepositoryMock());

        Execution startExecution = executionPipeline.run(ConfiguredExecution.getIitialExecution());

        Assert.assertNotNull(startExecution.getStatus());
        Assert.assertTrue(startExecution.getStatus().equals(Status.FAILED)
                || startExecution.getStatus().equals(Status.COMPLETED));
        Assert.assertNotNull(startExecution.getStartTime());
        Assert.assertNotNull(startExecution.getEndTime());

        for (Task task : startExecution.getTasks()) {
            Assert.assertNotNull(task.getStatus());
            Assert.assertNotNull(task.getStartTime());
            Assert.assertNotNull(task.getEndTime());
            if (task.getStatus().equals(Status.FAILED)) {
                return;
            }
        }

    }

}
