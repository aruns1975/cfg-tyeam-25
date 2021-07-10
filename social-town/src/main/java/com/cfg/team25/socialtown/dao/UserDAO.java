package com.cfg.team25.socialtown.dao;

import com.cfg.team25.socialtown.dao.mapper.UserRowMapper;
import com.cfg.team25.socialtown.dto.UserDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserDAO {

    @NonNull private JdbcTemplate jdbcTemplate;
    @NonNull private UserRowMapper userRowMapper;

    public int createUser(UserDTO userDto){
        String sql = "INSERT INTO user values (?,?,?,?,?)";
        return jdbcTemplate.update(sql,userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getRole(), userDto.getPassword());
    }

    public List<UserDTO> getAll(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql,userRowMapper);
    }

    public String getPassword(String userName){
        String sql ="select userpassword from user where username=?";
        log.info("Executing the query {} with the params {}",sql, userName);
        return jdbcTemplate.queryForObject(sql,String.class, userName);
    }
    public UserDTO getUser(String userName){
        String sql ="select * from user where username=?";
        log.info("Executing the query {} with the params {}",sql, userName);
        return jdbcTemplate.queryForObject(sql,userRowMapper, userName);
    }
}
