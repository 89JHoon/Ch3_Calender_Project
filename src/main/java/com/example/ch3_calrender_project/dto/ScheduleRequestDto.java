package com.example.ch3_calrender_project.dto;

import lombok.Data;

@Data
public class ScheduleRequestDto {
    private String name;
    private String pw;
    private String contents;
    private String title;
    private String date;
}
