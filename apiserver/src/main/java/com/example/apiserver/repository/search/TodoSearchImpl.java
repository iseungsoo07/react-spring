package com.example.apiserver.repository.search;

import static com.example.apiserver.domain.QTodo.todo;

import com.example.apiserver.domain.Todo;
import com.example.apiserver.dto.PageRequestDTO;
import com.querydsl.jpa.JPQLQuery;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1(PageRequestDTO pageRequestDTO) {

        log.info("search1 ------------------");

        JPQLQuery<Todo> query = from(todo);

        Pageable pageable = PageRequest.of(
            pageRequestDTO.getPage() - 1,
            pageRequestDTO.getSize(),
            Sort.by("tno").descending()
        );

        this.getQuerydsl().applyPagination(pageable, query);

        List<Todo> todoList = query.fetch();
        long totalCount = query.fetchCount();

        return new PageImpl<>(todoList, pageable, totalCount);
    }
}
