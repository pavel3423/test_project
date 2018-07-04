package by.application.test_project.service.impl;

import by.application.test_project.domain.Execution;
import by.application.test_project.repository.ExecutionRepository;
import by.application.test_project.service.ExecutionPipeline;
import by.application.test_project.service.ExecutionService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ExecutionServiceImpl implements ExecutionService {
    ExecutionPipeline executionPipeline;
    ExecutionRepository executionRepository;

    public ExecutionServiceImpl(ExecutionPipeline executionPipeline, ExecutionRepository executionRepository) {
        this.executionPipeline = executionPipeline;
        this.executionRepository = executionRepository;
    }

    public Execution create(Execution execution) throws Exception {
        executionRepository.save(execution);
        executionPipeline.run(execution);
        executionRepository.save(execution);
        return execution;
    }

    @Override
    public Execution readById(int id) {
        Optional<Execution> execution = executionRepository.findById(id);
        if (execution.isPresent()) {
            return execution.get();
        } else {
            return null;
        }
    }
}
