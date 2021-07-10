package com.cfg.team25.socialtown.service;

import com.cfg.team25.socialtown.dao.EventDAO;
import com.cfg.team25.socialtown.dto.EventDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    @NonNull private EventDAO eventDAO;

    public List<EventDTO> getAll(){
        return eventDAO.getAll();
    }

    public EventDTO findById(int id){
      return eventDAO.findById(id);
    }

    public EventDTO findByName(String eventName){
        return eventDAO.findByName(eventName);
    }

    public List<EventDTO> findByNgo(String ngo){
      return eventDAO.findByNgo(ngo);
    }

    public int createEvent(EventDTO eventDTO){
       return eventDAO.createEvent(eventDTO);
    }

    public int updateEvent(EventDTO eventDTO) {
        return eventDAO.updateEvent(eventDTO);
    }

    public int deleteEventById(int id){
        return eventDAO.deleteEventById(id);

    }

    public int deleteEventByName(String name){
        return eventDAO.deleteEventByName(name);
    }

    public int deleteEventByNgo(String ngo){
        return eventDAO.deleteEventByNgo(ngo);
    }

    public List<EventDTO> findEventForVolunteer(int userId) {
       return eventDAO.findEventForVolunteer(userId);
    }

    public List<EventDTO> findEventNotRegisteredByVolunteer(String userId){
        return eventDAO.findEventNotRegisteredByVolunteer(userId);
    }
}
