package by.application.test_project.repository;

import by.application.test_project.domain.Task;

import java.util.Optional;

public class TaskRepositoryMock implements TaskRepository {
    @Override
    public <S extends Task> S save(S s) {
        return null;
    }

    @Override
    public <S extends Task> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Task> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Task> findAll() {
        return null;
    }

    @Override
    public Iterable<Task> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Task task) {

    }

    @Override
    public void deleteAll(Iterable<? extends Task> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
