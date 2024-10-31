package com.danna.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.danna.movies.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    
}
