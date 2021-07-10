package com.cfg.team25.socialtown.dao.mapper;

import com.cfg.team25.socialtown.dto.EventDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class EventMapper implements RowMapper<EventDTO> {

    @Override
    public EventDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        return EventDTO.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("eventname"))
                .description(resultSet.getString("description"))
                .volunteerCount(resultSet.getInt("numberOfVolunteers"))
                .startDate(resultSet.getDate("startDate"))
                .duration(resultSet.getInt("durattion"))
                .area(resultSet.getString("area"))
                .ngo(resultSet.getString("ngoName"))
                .build();
    }
}
