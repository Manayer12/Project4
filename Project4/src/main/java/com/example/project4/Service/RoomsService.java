package com.example.project4.Service;

import com.example.project4.Api.ApiException;
import com.example.project4.Model.Rooms;
import com.example.project4.Repository.RoomsRepoository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RoomsService {
    final private RoomsRepoository roomsRepoository;

    public List<Rooms> getAll(){

        return roomsRepoository.findAll();
    }


    public void addRoom(Rooms rooms){
        roomsRepoository.save(rooms);
    }


    public void updateRoom(Integer id,Rooms rooms){
        Rooms oldroom=roomsRepoository.findRoomsById(id);
        if(oldroom==null){
            throw new ApiException("id not found");
        }
       oldroom.setType(rooms.getType());
        oldroom.setUsed(rooms.getUsed());
        roomsRepoository.save(oldroom);


    }

    public void  deleteRoom(Integer id){
        Rooms oldRoom=roomsRepoository.findRoomsById(id);
        if(oldRoom==null){
            throw new ApiException("id not found");
        }
        roomsRepoository.deleteById(id);

    }


    public List<Rooms> findbytype(String type){
        List<Rooms> oldtype=roomsRepoository.findRoomsByType(type);
        if (oldtype ==null){
            throw new ApiException("this type is not in our movies house");
        }
         return  roomsRepoository.findRoomsByType(type);

    }
    public List<Rooms> itnotbusy(){
        List<Rooms> notbusyrooms=roomsRepoository.busyroom();
        if (notbusyrooms.isEmpty()){
            throw new ApiException("All the rooms is busy");
        }
        return roomsRepoository.busyroom();

    }

    public Rooms changetype(Integer id){
        Rooms ctype=roomsRepoository.findRoomsById(id);
        if (ctype==null){
            throw new ApiException("room id not found");
        }
        if (ctype.getType().equals("Normal")){
         ctype.setType("Vip");
         roomsRepoository.save(ctype);
        }
        else {

            ctype.setType("Normal");
            roomsRepoository.save(ctype);

        }

        return ctype;




    }


}
