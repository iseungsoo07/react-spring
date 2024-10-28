package com.example.apiserver.controller;

import com.example.apiserver.dto.PageRequestDTO;
import com.example.apiserver.dto.PageResponseDTO;
import com.example.apiserver.dto.TodoDTO;
import com.example.apiserver.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable Long tno) {
        return todoService.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);

        return todoService.getList(pageRequestDTO);
    }
}
