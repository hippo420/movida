package app.movida.business.ctl;

import app.movida.business.entity.Movie;
import app.movida.business.repository.MovieRepository;
import app.movida.business.svc.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieRepository movieRepository;

    @GetMapping
    public String listMovies(@RequestParam(required = false) String tag, Model model) {
        List<Movie> movies = (tag == null)
                ? movieRepository.findAll()
                : movieRepository.findByTags_Name(tag);
        model.addAttribute("movies", movies);
        return "movies";
    }

    @PostMapping
    public String createMovie(@ModelAttribute Movie movie,
                              @RequestParam("tags") String tags,
                              @RequestParam("actorIds") List<Long> actorIds) {
        List<String> tagList = Arrays.stream(tags.split(","))
                .map(String::trim)
                .toList();
        movieService.createMovie(movie, tagList, actorIds);
        return "redirect:/movies";
    }
}
