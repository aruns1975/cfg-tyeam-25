package com.cfg.team25.socialtown.dao.mapper;

import com.cfg.team25.socialtown.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class UserRowMapper implements RowMapper<UserDTO> {


    @Override
    public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        return UserDTO.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("username"))
                        .email(resultSet.getString("email"))
                        .role(resultSet.getString("userrole"))
                        .build();
    }
}
