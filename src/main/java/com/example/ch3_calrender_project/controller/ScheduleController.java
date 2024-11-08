package com.example.ch3_calrender_project.controller;

import com.example.ch3_calrender_project.dto.ScheduleRequestDto;
import com.example.ch3_calrender_project.dto.ScheduleResponseDto;
import com.example.ch3_calrender_project.entity.Schedule;
import com.example.ch3_calrender_project.repository.ScheduleRepository;
import com.example.ch3_calrender_project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class ScheduleController {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    //일정 등록
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto){
        ScheduleService scheduleService=new ScheduleService(jdbcTemplate);
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedules/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id){
        ScheduleService scheduleService=new ScheduleService(jdbcTemplate);
        return scheduleService.getSchedule(id);
    }

    //전체 일정 목록 조회
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getScheduleList(){
        ScheduleService scheduleService=new ScheduleService(jdbcTemplate);
        return scheduleService.getScheduleList();
    }

    //선택한 일정 수정
    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto){
        ScheduleService scheduleService=new ScheduleService(jdbcTemplate);
        return scheduleService.updateSchedule(id,scheduleRequestDto);
    }

    //선택한 일정 삭제
    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id){
        ScheduleService scheduleService=new ScheduleService(jdbcTemplate);
        return scheduleService.deleteSchedule(id);
    }




}
