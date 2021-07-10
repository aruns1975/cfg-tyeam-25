package com.cfg.team25.socialtown.dao;

import com.cfg.team25.socialtown.dao.mapper.EventMapper;
import com.cfg.team25.socialtown.dto.EventDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventDAO {
    @NonNull private JdbcTemplate jdbcTemplate;
    @NonNull private EventMapper eventMapper;

    public List<EventDTO> getAll(){
        String sql = "select * from events";
        return jdbcTemplate.query(sql, eventMapper);
    }

    public EventDTO findById(int id){
        String sql = "select * from events where id =? ";
        List<EventDTO> events= jdbcTemplate.query(sql, eventMapper, id);
        if(events.size()==1)
            return events.get(0);
        return null;
    }

    public EventDTO findByName(String eventName){
        String sql = "select * from events where eventName =? ";

        List<EventDTO> events= jdbcTemplate.query(sql, eventMapper, eventName);
        if(events.size()==1)
            return events.get(0);
        return null;
    }

    public List<EventDTO> findByNgo(String ngo){
        String sql = "select * from events where ngo =? ";
        return jdbcTemplate.query(sql, eventMapper, ngo);
    }

    public int createEvent(EventDTO eventDTO){
        String sql ="insert into events values (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, eventDTO.getId()
                                       , eventDTO.getName()
                                        , eventDTO.getNgo()
                                        , eventDTO.getDescription()
                                        , eventDTO.getVolunteerCount()
                                        , eventDTO.getStartDate()
                                        ,eventDTO.getDuration()
                                        ,eventDTO.getArea()
        );
    }

    public int updateEvent(EventDTO eventDTO) {
        String sql = new StringBuilder()
                        .append("update events ")
                        .append("set eventname = ?, ")
                        .append("    ngoName =  ?, ")
                        .append("    description =  ?, ")
                        .append("    numberOfVolunteers =  ?, ")
                        .append("    startDate =  ?, ")
                        .append("    durattion =  ?, ")
                        .append("    area =  ? ")
                        .append("WHERE id=?  ")
                        .toString();
        return jdbcTemplate.update(sql
                                    , eventDTO.getName()
                                    , eventDTO.getNgo()
                                    , eventDTO.getDescription()
                                    , eventDTO.getVolunteerCount()
                                    , eventDTO.getStartDate()
                                    ,eventDTO.getDuration()
                                    ,eventDTO.getArea()
                                    ,eventDTO.getId()
        );
    }

    public int deleteEventById(int id){
        String sql = "delete from events where id=?";
        return jdbcTemplate.update(sql, id);

    }

    public int deleteEventByName(String name){
        String sql = "delete from events where eventname=?";
        return jdbcTemplate.update(sql, name);
    }

    public int deleteEventByNgo(String ngo){
        String sql = "delete from events where ngoName=?";
        return jdbcTemplate.update(sql, ngo);
    }

   public List<EventDTO> findEventForVolunteer(int userId) {
        String sql = new StringBuilder()
                .append("select e.* ")
                .append("from volunteer_event_assignent  vea ")
                .append("join user u on u.id = vea.user_id ")
                .append("join events e on e.id = vea.event_id ")
                .append("where u.id=? ")
                .toString();
        return jdbcTemplate.query(sql, eventMapper, userId);
    }

    public List<EventDTO> findEventNotRegisteredByVolunteer(String userId){
        String sql = new StringBuilder()
                .append("select e.* ")
                .append("from events e ")
                .append("where not exists( ")
                .append("					select 1  ")
                .append("					from volunteer_event_assignent  vea  ")
                .append("					where vea.event_id=e.id and vea.user_id=? ")
                .append("                ) ")
                .toString();
        return jdbcTemplate.query(sql, eventMapper, userId);
    }
}

