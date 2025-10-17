package app.movida.business.svc;

import app.movida.business.entity.Actor;
import app.movida.business.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ActorService {
    private final ActorRepository actorRepository;

    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }

    public List<Actor> searchByName(String name) {
        return actorRepository.findByNameContaining(name);
    }

    public Optional<Actor> getActor(Long id) {
        return actorRepository.findById(id);
    }

    public void ins(Actor actor) {
        actorRepository.save(actor);
    }
}
