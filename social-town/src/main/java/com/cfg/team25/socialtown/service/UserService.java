package com.cfg.team25.socialtown.service;

import com.cfg.team25.socialtown.dao.UserDAO;
import com.cfg.team25.socialtown.dto.UserDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    @NonNull
    private UserDAO userDao;

    public List<UserDTO> getAllUsers() {
        return userDao.getAll();
    }

    public int insertUser(UserDTO userDto){
        return userDao.createUser(userDto);
    }

    public UserDTO login(String userName, String password){
        String expectedPassword = userDao.getPassword(userName);
        log.info("The password from db is {}",expectedPassword);
        if(expectedPassword!=null && expectedPassword.equals(password)){
            return userDao.getUser(userName);
        }
        return null;
    }

    public UserDTO fetchUserDetails(String userName){
        return userDao.getUser(userName);

    }

}
