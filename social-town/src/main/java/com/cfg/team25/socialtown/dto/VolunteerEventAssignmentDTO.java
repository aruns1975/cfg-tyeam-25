package com.cfg.team25.socialtown.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VolunteerEventAssignmentDTO {
    private int id;
    private int volunteerId;
    private int eventId;
}
