package com.cfg.team25.socialtown.service;

import com.cfg.team25.socialtown.dao.VolunteerEventAssignementDAO;
import com.cfg.team25.socialtown.dto.VolunteerEventAssignmentDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VolunteerEventAssignmentService {
    @NonNull private VolunteerEventAssignementDAO volunteerEventAssignementDAO;

    public int assignEventToUser(int id, int userId, int eventId){
        return volunteerEventAssignementDAO.assignEventToUser(id, userId, eventId);
    }

    public int unAssignEventFrom (int eventId, int userId) {
        return volunteerEventAssignementDAO.unAssignEventFrom(eventId, userId);

    }
}
