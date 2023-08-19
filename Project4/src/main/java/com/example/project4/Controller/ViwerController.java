package com.example.project4.Controller;

import com.example.project4.Api.ApiResponse;
import com.example.project4.Model.Viwer;
import com.example.project4.Service.ViwerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/viwer")
public class ViwerController {

private final ViwerService viwerService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(viwerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Viwer viwer){
        viwerService.addViwer(viwer);
        return ResponseEntity.status(200).body(new ApiResponse("viwer added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid  Viwer viwer){
        viwerService.updateViwer(id,viwer);
        return ResponseEntity.status(200).body(new ApiResponse("viwer updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        viwerService.deleteViwer(id);
        return ResponseEntity.status(200).body(new ApiResponse("viwer deleted"));
    }

 //depending on the age of the viwer it will show  movies for them
    @GetMapping("/listbasedage/{id}")
    public ResponseEntity checkage(@PathVariable Integer id){
        return ResponseEntity.status(200).body(viwerService.checkage(id));

    }

    @GetMapping("/buyticket/{id}/{moviename}/{numofticket}")
    public ResponseEntity checkage(@PathVariable Integer id,@PathVariable String moviename,@PathVariable Integer numofticket){
        viwerService.buyticket(id,moviename,numofticket);
        return ResponseEntity.status(200).body(new ApiResponse("your ticket is purchased,thank you"));

    }

    @GetMapping("returnticket/{id}/{moviename}/{numofticket}")
    public ResponseEntity returntickets(@PathVariable Integer id,@PathVariable String moviename,@PathVariable Integer numofticket) {
        viwerService.returnticket(id,moviename,numofticket);
        return ResponseEntity.status(200).body(new ApiResponse("your purchased is returned,thank you"));

    }

        @GetMapping("/vip")
    private ResponseEntity vipviwers(){
        return ResponseEntity.status(200).body(viwerService.VipViwers());
    }





}
