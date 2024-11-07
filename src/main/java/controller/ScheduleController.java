package controller;

import dto.ScheduleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ScheduleService;
import service.ScheduleServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @GetMapping
    public List<ScheduleDto> allScheduleList() {

        List<ScheduleDto> responseList = new ArrayList<>();
        return scheduleService.allScheduleList();
    }

}
