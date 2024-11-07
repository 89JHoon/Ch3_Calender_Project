package com.example.ch3_calrender_project.entity;

import com.example.ch3_calrender_project.dto.ScheduleRequestDto;
import lombok.Data;

@Data
public class Schedule {
    private Long id;
    private String name;
    private String pw;
    private String content;
    private String title;
    private String date;

    public Schedule(ScheduleRequestDto scheduleRequestDto){
        this.name= scheduleRequestDto.getName();
        this.pw=scheduleRequestDto.getPw();
        this.content=scheduleRequestDto.getContents();
        this.title =scheduleRequestDto.getTitle();
        this.date=scheduleRequestDto.getDate();
    }
}
