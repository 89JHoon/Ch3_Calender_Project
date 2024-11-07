package service;

import dto.ScheduleDto;

import java.util.List;

public interface ScheduleService {

    //스케줄 전체 조회
    List<ScheduleDto> allScheduleList();

    // 세부 스케줄 조회
    ScheduleDto detailSchedule(int num);

    //스케줄 삭제
    void deleteSchedule(String id,String pw);

}
