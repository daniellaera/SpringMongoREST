package com.example.SpringMongoREST.exception;

public class MovieCollectionException extends Exception {

    public MovieCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "Movie with " + id + "not found";
    }

    public static String TitleAlreadyExists() {
        return "Movie with given title already exists!";
    }
}
