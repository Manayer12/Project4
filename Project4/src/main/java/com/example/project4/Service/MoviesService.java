package com.example.project4.Service;

import com.example.project4.Api.ApiException;
import com.example.project4.Model.Movie;
import com.example.project4.Repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesService {
    final private MoviesRepository moviesRepository;

    public List<Movie>getAll(){

        return moviesRepository.findAll();
    }


    public void addMovie(Movie movie){
        moviesRepository.save(movie);
    }


    public void updateMovie(Integer id, Movie movie){
        Movie oldmovie=moviesRepository.findMoviesById(id);
        if(oldmovie==null){
            throw new ApiException("id not found");
        }
        oldmovie.setName(movie.getName());
        oldmovie.setDescription(movie.getDescription());
        oldmovie.setTicketprice(movie.getTicketprice());
        oldmovie.setChairsamount(movie.getChairsamount());
        oldmovie.setHours(movie.getHours());
        oldmovie.setRating(movie.getRating());
        moviesRepository.save(oldmovie);
    }

    public void  deleteMovie(Integer id){
        Movie oldmovie=moviesRepository.findMoviesById(id);
        if(oldmovie==null){
            throw new ApiException("id not found");
        }
        moviesRepository.deleteById(id);

    }

    public Movie findMovie(String name){
        Movie moviename=moviesRepository.findMovieByName(name);
        if(moviename==null){
            throw new ApiException("movie name not found");
        }
        return moviename;
    }

    public List<Movie> findbyhoures(){
        List<Movie> moviehoures=moviesRepository.movieh();
       if (moviehoures == null){
           throw new ApiException("No movie has a duration of more than 2h");
        }

       return moviesRepository.movieh();
    }
    public List<Movie> propertokids(){
      List<Movie> kids=moviesRepository.kidsmovie();
      if (kids==null){
          throw new ApiException(" there are no movies for kids");
      }

      return moviesRepository.kidsmovie();

    }

    public List<Movie> allowedmovies(){

        List<Movie> allmovies=moviesRepository.allowedmoviesrunder18();
        if (allmovies==null){
            throw new ApiException(" there are no movies proper to under 18 ");
        }

        return moviesRepository.allowedmoviesrunder18();

    }

    public List<Movie> allowedmovies15(){

        List<Movie> allmovies=moviesRepository.allowedmoviesunder15();
        if (allmovies==null){
            throw new ApiException(" there are no movies proper to under 15 ");
        }

        return moviesRepository.allowedmoviesunder15();

    }

    public List<Movie> allowedmovies12(){

        List<Movie> allmovies=moviesRepository.allowedmoviesunder12();
        if (allmovies==null){
            throw new ApiException(" there are no movies proper to under 12 ");
        }

        return moviesRepository.allowedmoviesunder12();

    }

    public Movie offers(String name){
        Movie offerm=moviesRepository.findMovieByName(name);
        if(offerm == null){
            throw new ApiException("no movie with this name");
        }
        offerm.setTicketprice(offerm.getTicketprice()-offerm.getTicketprice()*10/100);

        return moviesRepository.save(offerm);
    }







}
