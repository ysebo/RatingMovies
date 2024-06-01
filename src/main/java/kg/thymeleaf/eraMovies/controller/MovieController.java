package kg.thymeleaf.eraMovies.controller;

import kg.thymeleaf.eraMovies.model.Movie;
import kg.thymeleaf.eraMovies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor

public class MovieController {
    private final MovieRepository movieRepository;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", movieRepository.findAllByOrderByRatingDesc());
        return "index";
    }

    @PostMapping("/add")
    public String addMovie(@RequestParam String name, @RequestParam int rating) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setRating(rating);
        movieRepository.save(movie);
        return "redirect:/";
    }
}
