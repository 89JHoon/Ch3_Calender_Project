package com.example.ch3_calrender_project.controller;

import com.example.ch3_calrender_project.dto.ScheduleRequestDto;
import com.example.ch3_calrender_project.dto.ScheduleResponseDto;
import com.example.ch3_calrender_project.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.ScheduleRepository;

@RestController
@RequestMapping("/main")
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository){
        this.scheduleRepository=scheduleRepository;
    }
    //일정 등록
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto){
        //RequestDto -> Entity
        Schedule schedule=new Schedule(requestDto);
        //임시저장소 저장
        scheduleRepository.save(schedule);
        //Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto=new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }
}
