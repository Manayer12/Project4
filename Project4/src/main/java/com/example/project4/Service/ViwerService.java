package com.example.project4.Service;

import com.example.project4.Api.ApiException;
import com.example.project4.Model.Movie;
import com.example.project4.Model.Viwer;
import com.example.project4.Repository.MoviesRepository;
import com.example.project4.Repository.ViwerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ViwerService {
    final private ViwerRepository viwerRepository;
    @Autowired
    final private MoviesService moviesService;
    final private MoviesRepository moviesRepository;

    public List<Viwer> getAll() {

        return viwerRepository.findAll();
    }


    public void addViwer(Viwer viwer) {
        viwerRepository.save(viwer);
    }


    public void updateViwer(Integer id, Viwer viwer) {
        Viwer oldViwer = viwerRepository.findViewerById(id);
        if (oldViwer == null) {
            throw new ApiException("id not found");
        }
        oldViwer.setName(viwer.getName());
        oldViwer.setAge(viwer.getAge());
        oldViwer.setPassword(viwer.getPassword());
        oldViwer.setEmail(viwer.getEmail());
        oldViwer.setBalance(viwer.getBalance());
        viwerRepository.save(oldViwer);


    }

    public void deleteViwer(Integer id) {
        Viwer oldViwer = viwerRepository.findViewerById(id);
        if (oldViwer == null) {
            throw new ApiException("id not found");
        }
        viwerRepository.deleteById(id);
    }


    public List<Movie> checkage(Integer id) {
        Viwer oldviwer=viwerRepository.findViewerById(id);

        if (oldviwer == null) {
            throw new ApiException("id not found");
        }

        Integer age = oldviwer.getAge();

        if (age >=18) {
           return moviesService.getAll();
        }

        if (age <15 && age >12) {
            return moviesService.allowedmovies15();
        }

         if (age <12){

            return moviesService.allowedmovies12();
        }

        return moviesService.allowedmovies();

    }

    public void buyticket(Integer id,String name,Integer numofticket){
        Viwer viwer1=viwerRepository.findViewerById(id);
        if (viwer1 ==null){
            throw new ApiException("can not find id");
        }
        Movie oldmovie=moviesService.findMovie(name);
        viwer1.setAmountoftickets(numofticket);
        viwer1.setBalance(viwer1.getBalance()-oldmovie.getTicketprice()*numofticket);
        oldmovie.setChairsamount(oldmovie.getChairsamount()-numofticket);

        moviesRepository.save(oldmovie);
        viwerRepository.save(viwer1);
    }

    public void returnticket(Integer id,String name,Integer numofticket){
        Viwer viwer2=viwerRepository.findViewerById(id);
        if (viwer2 ==null || viwer2.getAmountoftickets()==null ){
            throw new ApiException("can not find viwer id or you dont have ticket to return");
        }

        Movie oldmovie=moviesService.findMovie(name);
        viwer2.setAmountoftickets(viwer2.getAmountoftickets()-numofticket);
        viwer2.setBalance(viwer2.getBalance()+oldmovie.getTicketprice()*numofticket);
        oldmovie.setChairsamount(oldmovie.getChairsamount()+numofticket);
        moviesRepository.save(oldmovie);
        viwerRepository.save(viwer2);
    }


    public List<Viwer> VipViwers(){
    List<Viwer> viwer2=viwerRepository.vipviwers();
    if (viwer2==null){
        throw new ApiException("no Vip Viwers");
    }
    return viwerRepository.vipviwers();

    }
}









