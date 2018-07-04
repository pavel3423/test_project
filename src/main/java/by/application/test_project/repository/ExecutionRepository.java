package by.application.test_project.repository;

import by.application.test_project.domain.Execution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionRepository extends CrudRepository<Execution, Integer> {
}
