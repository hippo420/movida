package app.movida.business.svc;

import app.movida.business.entity.Actor;
import app.movida.business.entity.Movie;
import app.movida.business.entity.Tag;
import app.movida.business.repository.ActorRepository;
import app.movida.business.repository.MovieRepository;
import app.movida.business.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final TagRepository tagRepository;
    private final ActorRepository actorRepository;

    public void createMovie(Movie movie, List<String> tagNames, List<Long> actorIds) {
        // 배우 연결
        List<Actor> actors = actorRepository.findAllById(actorIds);
        movie.setActors(new HashSet<>(actors));

        // 태그 연결
        Set<Tag> tags = new HashSet<>();
        for (String name : tagNames) {
            Tag tag = tagRepository.findByName(name)
                    .orElseGet(() -> tagRepository.save(Tag.builder().name(name).build()));
            tags.add(tag);
        }
        movie.setTags(tags);

        movieRepository.save(movie);
    }
}
