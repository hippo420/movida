package app.movida.business.svc;

import app.movida.business.entity.Site;
import app.movida.business.repository.SiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SiteService {
    private final SiteRepository siteRepository;
    public List<Site> searchALl() {
        return siteRepository.findAll();
    }

    public void ins(Site site) {
        siteRepository.save(site);
    }
}
