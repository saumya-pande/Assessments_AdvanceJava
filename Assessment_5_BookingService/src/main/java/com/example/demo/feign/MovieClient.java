package com.example.demo.feign;

import com.example.demo.dto.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service")  // remove fallback from here
public interface MovieClient {
    @GetMapping("/movies/{id}")
    Movie getMovieById(@PathVariable("id") long id);
}