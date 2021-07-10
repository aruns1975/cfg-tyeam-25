package com.cfg.team25.socialtown.controller;

import com.cfg.team25.socialtown.dto.UserDTO;
import com.cfg.team25.socialtown.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @NonNull  private UserService userService;

    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "", consumes = "application/json")
    public int insertUser(@RequestBody UserDTO userDTO){
        return userService.insertUser(userDTO);
    }

    @PostMapping(value="login")
    public UserDTO login(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return userService.login(userName,password);
    }

    @GetMapping(value="/details")
    public UserDTO userDetails(@RequestParam("userName") String userName){
        return userService.fetchUserDetails(userName);
    }
}
