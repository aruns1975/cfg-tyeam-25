package com.cfg.team25.socialtown.controller;

import com.cfg.team25.socialtown.dto.EventDTO;
import com.cfg.team25.socialtown.service.EventService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {
    @NonNull private EventService eventService;

    @GetMapping
    public List<EventDTO> getAll(){
        return eventService.getAll();
    }

    @GetMapping("/byId/{id}")
    public EventDTO findById(@PathVariable("id") int id){
        return eventService.findById(id);
    }

    @GetMapping("/byName/{name}")
    public EventDTO findByName(@PathVariable("name") String eventName){
        return eventService.findByName(eventName);
    }

    @GetMapping("/byNgo/{ngo}")
    public List<EventDTO> findByNgo(@PathVariable("ngo") String ngo){
        return eventService.findByNgo(ngo);
    }

    @PostMapping()
    public int createEvent(@RequestBody EventDTO eventDTO){
        return eventService.createEvent(eventDTO);
    }

    @PutMapping
    public int updateEvent(@RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(eventDTO);
    }

    @DeleteMapping("/byId/{id}")
    public int deleteEventById(@PathVariable("id") int id){
        return eventService.deleteEventById(id);

    }

    @DeleteMapping("/byName/{name}")
    public int deleteEventByName(@PathVariable("name") String name){
        return eventService.deleteEventByName(name);
    }

    @DeleteMapping("/byNgo/{ngo}")
    public int deleteEventByNgo(@PathVariable("ngo") String ngo){
        return eventService.deleteEventByNgo(ngo);
    }

    @GetMapping("/registeredByUser/{id}")
    public List<EventDTO> findEventForVolunteer(@PathVariable("id") int userId) {
        return eventService.findEventForVolunteer(userId);
    }

    @GetMapping("/notRegisteredByUser/{id}")
    public List<EventDTO> findEventNotRegisteredByVolunteer(@PathVariable("id") String userId){
        return eventService.findEventNotRegisteredByVolunteer(userId);
    }
}
