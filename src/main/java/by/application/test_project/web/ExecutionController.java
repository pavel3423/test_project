package by.application.test_project.web;

import by.application.test_project.domain.Execution;
import by.application.test_project.service.ExecutionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/execution")
public class ExecutionController {

    private final ExecutionService executionService;

    public ExecutionController(ExecutionService executionService) {
        this.executionService = executionService;
    }

    @GetMapping(produces = "application/x-yaml")
    public Execution create(@RequestParam(name = "executionId") Integer executionId) {

        return executionService.readById(executionId);
    }

    @PutMapping(consumes = "application/yaml", produces = "application/yaml")
    @ResponseStatus(HttpStatus.OK)
    public Execution create(@RequestBody Execution execution) throws Exception {

        return executionService.create(execution);
    }

}
