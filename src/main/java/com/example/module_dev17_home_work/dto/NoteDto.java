package com.example.module_dev17_home_work.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private LocalDate lastUpdatedDate;
    private LocalDate createdDate;
}
