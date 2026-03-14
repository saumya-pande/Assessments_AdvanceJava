package com.example.demo.feign;

import com.example.demo.dto.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieClientFallback implements MovieClient {
    @Override
    public Movie getMovieById(long id) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setPrice(0.0);
        movie.setName("Unavailable");
        return movie;
    }
}