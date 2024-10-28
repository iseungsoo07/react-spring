package com.example.apiserver.service;

import com.example.apiserver.domain.Todo;
import com.example.apiserver.dto.PageRequestDTO;
import com.example.apiserver.dto.PageResponseDTO;
import com.example.apiserver.dto.TodoDTO;

public interface TodoService {

    TodoDTO get(Long tno);

    Long register(TodoDTO todoDTO);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

    PageResponseDTO <TodoDTO> getList(PageRequestDTO pageRequestDTO);


    default TodoDTO entityToDTO(Todo todo) {
        return TodoDTO.builder()
            .tno(todo.getTno())
            .title(todo.getTitle())
            .content(todo.getContent())
            .complete(todo.isComplete())
            .dueDate(todo.getDueDate())
            .build();
    }

    default Todo dtoToEntity(TodoDTO todoDTO) {
        return Todo.builder()
            .tno(todoDTO.getTno())
            .title(todoDTO.getTitle())
            .content(todoDTO.getContent())
            .complete(todoDTO.isComplete())
            .dueDate(todoDTO.getDueDate())
            .build();
    }
}
