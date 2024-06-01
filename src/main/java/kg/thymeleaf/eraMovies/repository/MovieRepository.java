package kg.thymeleaf.eraMovies.repository;

import kg.thymeleaf.eraMovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m ORDER BY m.rating DESC")
    List<Movie> findAllByOrderByRatingDesc();
}
