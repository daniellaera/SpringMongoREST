package com.example.SpringMongoREST.controller;

import com.example.SpringMongoREST.exception.MovieCollectionException;
import com.example.SpringMongoREST.model.Movie;
import com.example.SpringMongoREST.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.POST, value = "/movie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            movieService.createMovie(movie);
            return new ResponseEntity("Successfully added movie" + movie.getTitle(), HttpStatus.OK);
        }
        catch (ConstraintViolationException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (MovieCollectionException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movie")
    public ResponseEntity getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity(movies, movies.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
