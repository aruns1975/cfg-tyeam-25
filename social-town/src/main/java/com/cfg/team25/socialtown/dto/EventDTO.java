package com.cfg.team25.socialtown.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class EventDTO {
    private int id;
    private String name;
    private String description;
    private int volunteerCount;
    private Date startDate;
    private int duration;
    private String area;
    private String ngo;
}
