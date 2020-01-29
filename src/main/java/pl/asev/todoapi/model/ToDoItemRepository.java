package pl.asev.todoapi.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ToDoItemRepository extends CrudRepository<ToDoItem,Long> {

   Optional<ToDoItem> findById(Long id);
}
