package dto;

import lombok.Data;

import java.util.Date;


@Data

public class ScheduleDto {
    private String name;
    private String id;
    private String pw;
    private String title;
    private String content;
    private Date date;
}
