package com.example.apiserver.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.apiserver.domain.Todo;
import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Log4j2
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1() {
        assertNotNull(todoRepository);

        log.info(todoRepository.getClass().getName());
    }

    @Test
    public void testInsert() {
        Todo todo = Todo.builder()
            .title("Title")
            .content("Content...")
            .dueDate(LocalDate.of(2024, 10, 25))
            .build();

        Todo savedTodo = todoRepository.save(todo);

        assertThat(savedTodo.getTitle()).isEqualTo("Title");
        assertThat(savedTodo.getContent()).isEqualTo("Content...");
        assertThat(savedTodo.getDueDate()).isEqualTo(LocalDate.of(2024, 10, 25));
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

        Page<Todo> pageTodo = todoRepository.findAll(pageable);

        log.info(pageTodo.getContent());
    }
}