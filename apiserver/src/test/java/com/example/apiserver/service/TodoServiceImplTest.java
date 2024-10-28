package com.example.apiserver.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.apiserver.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class TodoServiceImplTest {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet() {
        TodoDTO todoDTO = todoService.get(1L);

        log.info(todoDTO);
    }
}