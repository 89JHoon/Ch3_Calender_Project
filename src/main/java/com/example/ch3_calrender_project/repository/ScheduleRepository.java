package com.example.ch3_calrender_project.repository;

import com.example.ch3_calrender_project.dto.ScheduleRequestDto;
import com.example.ch3_calrender_project.dto.ScheduleResponseDto;
import com.example.ch3_calrender_project.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
    //DB저장
    public Schedule save(Schedule schedule) {
        KeyHolder keyHolder=new GeneratedKeyHolder(); //기본 키를 반환받기 위한 객체

        String sql="INSERT INTO schedule (name, pw, title, content, date) VALUES (?,?,?,?,?)";

        jdbcTemplate.update(con ->{
            PreparedStatement preparedStatement=con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,schedule.getName());
            preparedStatement.setString(2,schedule.getPw());
            preparedStatement.setString(3,schedule.getTitle());
            preparedStatement.setString(4,schedule.getContent());
            preparedStatement.setString(5,schedule.getDate());

            return preparedStatement;
        },keyHolder);

        Long id=keyHolder.getKey().longValue();
        schedule.setId(id);
        return schedule;
    }
    //선택한 id 조회
    public Schedule findById(Long id){
        String sql="SELECT * FROM schedule WHERE id = ?";

        return jdbcTemplate.query(sql,resultSet ->{
            if(resultSet.next()){
                Schedule schedule=new Schedule();
                schedule.setName(resultSet.getString("name"));
                schedule.setTitle(resultSet.getString("title"));
                schedule.setContent(resultSet.getString("content"));
                return schedule;
            }else{
                return null;
            }
        },id);
    }
    //전체 조회
    public List<ScheduleResponseDto> findAll() {
        //DB 조회
        String sql="SELECT * FROM schedule";

        return jdbcTemplate.query(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet result, int rowNum) throws SQLException {
                Long id=result.getLong("id");
                String name=result.getString("name");
                String title = result.getString("title");
                String content=result.getString("content");
                String date=result.getString("date");
                return new ScheduleResponseDto(id,name,title,content,date);
            }
        });
    }
    //삭제
    public void delete(Long id) {
        String sql="DELETE FROM schedule WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
    //수정
    public void updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        String sql="UPDATE schedule SET name = ?, title = ?,content = ?, WHERE id = ?";
        jdbcTemplate.update(sql,scheduleRequestDto.getName(),scheduleRequestDto.getContent(),id);
    }
    public ScheduleResponseDto find(Long id) {
        String sql="SELECT * FROM schedule WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet result, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getString("title"),
                        result.getString("content"),
                        result.getString("date")
                );
            }
        },id);
    }
}
