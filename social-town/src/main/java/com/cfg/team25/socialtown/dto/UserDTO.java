package com.cfg.team25.socialtown.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String role;
    @ToString.Exclude
    private String password;
}
