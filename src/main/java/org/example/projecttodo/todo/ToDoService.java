package org.example.projecttodo.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ToDoService {
    @Autowired
    private ToDoDAO dao;

    // 추가 save
    public void saveToDo(ToDoDTO toDoDto) {
        ToDo entity = new ToDo(toDoDto.getNumber(), toDoDto.getContent(), toDoDto.isCompleted());
        dao.save(entity);
    }

    // 모두 조회 selectAll
    public List<ToDoDTO> selectAllToDo() {
        List<ToDo> toDoList = dao.findAll();
        List<ToDoDTO> dtoList = new ArrayList<>();

        for (ToDo toDo : toDoList) {
            dtoList.add(new ToDoDTO(toDo.getNumber(), toDo.getContent(), toDo.isCompleted()));
        }
        return dtoList;
    }

    // 개별 조회
    public ToDoDTO selectToDo(int number) {
        ToDo toDo = dao.findById(number).orElse(null);
        ToDoDTO toDoDTO = new ToDoDTO(toDo.getNumber(), toDo.getContent(), toDo.isCompleted());
        return toDoDTO;
    }

    // 수정
    public void updateToDo(ToDoDTO toDoDto) {
        ToDo toDo = dao.findById(toDoDto.getNumber()).orElse(null);
        toDo.update(toDoDto);
    }

    // 삭제 delete
    public void deleteToDo(int number) {
        dao.deleteById(number);
    }
}
