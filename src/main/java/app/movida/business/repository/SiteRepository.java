package app.movida.business.repository;

import app.movida.business.entity.Movie;
import app.movida.business.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {

}
