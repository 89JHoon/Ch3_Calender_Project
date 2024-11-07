package service;

import dto.ScheduleDto;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;
import repository.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleServiceImpl {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Observed
    public List<ScheduleDto> allScheduleList() {
        return scheduleRepository.allScheduleList();
    }
}