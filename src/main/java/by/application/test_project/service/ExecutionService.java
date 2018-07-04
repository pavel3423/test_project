package by.application.test_project.service;

import by.application.test_project.domain.Execution;
import by.application.test_project.utils.IllegalPipelineException;

import java.util.concurrent.ExecutionException;

public interface ExecutionService {
    Execution create(Execution execution) throws IllegalPipelineException, ExecutionException, InterruptedException, Exception;

    Execution readById(int id);
}
