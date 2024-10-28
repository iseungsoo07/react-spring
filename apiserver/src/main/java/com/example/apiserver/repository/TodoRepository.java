package com.example.apiserver.repository;

import com.example.apiserver.domain.Todo;
import com.example.apiserver.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {

}
