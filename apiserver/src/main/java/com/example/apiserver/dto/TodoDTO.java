package com.example.apiserver.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TodoDTO {

    private Long tno;
    private String title;
    private String content;
    private boolean complete;
    private LocalDate dueDate;
}
