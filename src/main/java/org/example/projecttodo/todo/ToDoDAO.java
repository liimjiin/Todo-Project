package org.example.projecttodo.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoDAO extends JpaRepository<ToDo, Integer> {
}
