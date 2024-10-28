package com.example.apiserver.repository.search;

import com.example.apiserver.domain.Todo;
import com.example.apiserver.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1(PageRequestDTO pageRequestDTO);
}
