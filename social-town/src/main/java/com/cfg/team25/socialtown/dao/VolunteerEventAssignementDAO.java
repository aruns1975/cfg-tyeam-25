package com.cfg.team25.socialtown.dao;

import com.cfg.team25.socialtown.dao.mapper.EventMapper;
import com.cfg.team25.socialtown.dao.mapper.VolunteerEventAssignmentMapper;
import com.cfg.team25.socialtown.dto.EventDTO;
import com.cfg.team25.socialtown.dto.VolunteerEventAssignmentDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VolunteerEventAssignementDAO {
    @NonNull private JdbcTemplate jdbcTemplate;

    public int assignEventToUser(int id, int userId, int eventId){
        String sql = "insert into volunteer_event_assignent values (?,?,?)";
        return jdbcTemplate.update(sql,id, userId, eventId);
    }

    public int unAssignEventFrom (int eventId, int userId) {
        String sql = "delete from volunteer_event_assignent where user_id=? and event_id=?";
        return jdbcTemplate.update(sql,userId, eventId );

    }


}
