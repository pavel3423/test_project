package by.application.test_project.service;

import by.application.test_project.domain.Execution;
import by.application.test_project.utils.IllegalPipelineException;

import java.util.concurrent.ExecutionException;

public interface ExecutionPipeline {
    Execution run(Execution execution) throws IllegalPipelineException, ExecutionException, InterruptedException, Exception;
}
