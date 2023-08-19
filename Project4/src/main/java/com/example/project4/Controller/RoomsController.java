package com.example.project4.Controller;
import com.example.project4.Api.ApiResponse;
import com.example.project4.Model.Rooms;
import com.example.project4.Service.RoomsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
public class RoomsController {

    private final RoomsService roomsService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(roomsService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Rooms rooms){
        roomsService.addRoom(rooms);
        return ResponseEntity.status(200).body(new ApiResponse("room added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid  Rooms rooms){
       roomsService.updateRoom(id,rooms);
        return ResponseEntity.status(200).body(new ApiResponse("room updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
    roomsService.deleteRoom(id);
    return ResponseEntity.status(200).body(new ApiResponse("room deleted"));
    }
//get by type
    @GetMapping("/types/{type}")
    public ResponseEntity fbType(@PathVariable String type){
        return ResponseEntity.status(200).body(roomsService.findbytype(type));

    }

 //get the unbusy rooms
    @GetMapping("/notbusyroom")
    public ResponseEntity isBusy(){
        return ResponseEntity.status(200).body(roomsService.itnotbusy());
    }


    @PutMapping("/ctype/{id}")
    public ResponseEntity ctype(@PathVariable Integer id){

        return ResponseEntity.status(200).body(roomsService.changetype(id));


    }

}
