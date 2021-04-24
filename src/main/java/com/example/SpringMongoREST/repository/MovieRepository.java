package com.example.SpringMongoREST.repository;

import com.example.SpringMongoREST.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
    @Query("{'title':?0}")
    Optional<Movie> findByTitle(String title);
}
