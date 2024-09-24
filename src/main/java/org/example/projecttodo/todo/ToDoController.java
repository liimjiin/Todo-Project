package org.example.projecttodo.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService service;

    // 추가
    @PostMapping("/add")
    public void addToDo(@RequestBody ToDoDTO toDo) {
        service.saveToDo(toDo);
    }

    // 조회
    @GetMapping("/list")
    public List<ToDoDTO> getAllToDo() {
        return service.selectAllToDo();
    }

    // 수정
    @PutMapping("/update")
    public void updateToDo(@RequestBody ToDoDTO toDo) {
        System.out.println(toDo);
        service.updateToDo(toDo);
    }

    // 삭제
    @DeleteMapping("/delete")
    public void deleteToDo(int number) {
        service.deleteToDo(number);
    }
}
