package com.example.apiserver.service;

import com.example.apiserver.domain.Todo;
import com.example.apiserver.dto.PageRequestDTO;
import com.example.apiserver.dto.PageResponseDTO;
import com.example.apiserver.dto.TodoDTO;
import com.example.apiserver.repository.TodoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDTO get(Long tno) {
        Todo todo = todoRepository.findById(tno)
            .orElseThrow(() -> new NoSuchElementException("No Data"));

        return entityToDTO(todo);
    }

    @Override
    public Long register(TodoDTO todoDTO) {
        Todo savedTodo = todoRepository.save(dtoToEntity(todoDTO));

        return savedTodo.getTno();
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(todoDTO.getTno())
            .orElseThrow(() -> new NoSuchElementException("No Data"));

        todo.changeTitle(todoDTO.getTitle());
        todo.changeDueDate(todoDTO.getDueDate());
        todo.changeComplete(todoDTO.isComplete());
    }

    @Override
    public void remove(Long tno) {
        Todo todo = todoRepository.findById(tno)
            .orElseThrow(() -> new NoSuchElementException("No Data"));
        todoRepository.delete(todo);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        Page<Todo> result = todoRepository.search1(pageRequestDTO);

        Page<TodoDTO> todoDtoPage = result.map(this::entityToDTO);
        List<TodoDTO> dtoList = todoDtoPage.stream().toList();

        return PageResponseDTO.<TodoDTO>withAll()
            .dtoList(dtoList).pageRequestDTO(pageRequestDTO).total(result.getTotalElements())
            .build();
    }
}
