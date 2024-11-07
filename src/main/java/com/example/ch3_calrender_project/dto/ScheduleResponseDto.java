package com.example.ch3_calrender_project.dto;

import com.example.ch3_calrender_project.entity.Schedule;
import lombok.Data;

@Data
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String content;
    private String title;
    private String date;

    public ScheduleResponseDto(Schedule schedule){
        this.id=schedule.getId();
        this.name=schedule.getName();
        this.content=schedule.getContent();
        this.title = schedule.getTitle();
        this.date=schedule.getDate();
    }
    public ScheduleResponseDto(Long id,String name,String content,String title ,String date){
        this.id=id;
        this.name=name;
        this.content=content;
        this.date=date;
        this.title= title;
    }
}
