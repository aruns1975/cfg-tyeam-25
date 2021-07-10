package com.cfg.team25.socialtown.controller;

import com.cfg.team25.socialtown.service.VolunteerEventAssignmentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteerEventAssignment")
@RequiredArgsConstructor
public class VolunteerEventAssignmentController {
    @NonNull private VolunteerEventAssignmentService volunteerEventAssignmentService;

    @PostMapping()
    public int assignEventToUser(@RequestParam("id") int id,@RequestParam("userId") int userId,@RequestParam("eventId") int eventId){
        return volunteerEventAssignmentService.assignEventToUser(id, userId, eventId);
    }


    @DeleteMapping()
    public int unAssignEventFrom (@RequestParam("eventId") int eventId, @RequestParam("userid") int userId) {
        return volunteerEventAssignmentService.unAssignEventFrom(eventId, userId);

    }
}
