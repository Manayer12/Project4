package com.example.project4.Controller;

import com.example.project4.Api.ApiResponse;
import com.example.project4.Model.Movie;
import com.example.project4.Service.MoviesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MoviesController {
    private final MoviesService moviesService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(moviesService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Movie movie){
        moviesService.addMovie(movie);
        return ResponseEntity.status(200).body(new ApiResponse("movie added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Movie movie){
        moviesService.updateMovie(id, movie);
        return ResponseEntity.status(200).body(new ApiResponse("movie updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        moviesService.deleteMovie(id);
        return ResponseEntity.status(200).body(new ApiResponse("movie deleted"));
    }
   // return movie by name
    @GetMapping("/findbyname/{name}")
    public ResponseEntity find(@PathVariable String name){

        return ResponseEntity.status(200).body(moviesService.findMovie(name));
    }

    //return movies which is more than two h duration
    @GetMapping("/findhoures")
    public ResponseEntity findh(){

        return ResponseEntity.status(200).body(moviesService.findbyhoures());
    }

    @GetMapping("/kidsmovies")
    public ResponseEntity kidsmovies(){
        return ResponseEntity.status(200).body(moviesService.propertokids());
    }

//apply 10% offers on movie ticket
    @GetMapping("/offers/{name}")
    private ResponseEntity offers(@PathVariable String name){
        return ResponseEntity.status(200).body(moviesService.offers(name));



    }



}
