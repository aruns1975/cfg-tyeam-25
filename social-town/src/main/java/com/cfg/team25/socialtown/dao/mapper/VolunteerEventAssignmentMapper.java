package com.cfg.team25.socialtown.dao.mapper;

import com.cfg.team25.socialtown.dto.VolunteerEventAssignmentDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class VolunteerEventAssignmentMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return VolunteerEventAssignmentDTO.builder()
                                    .id(resultSet.getInt("id"))
                                    .volunteerId(resultSet.getInt("user_id"))
                                    .eventId(resultSet.getInt("event_id"))
                                    .build();
    }
}
