package app.movida.business.ctl;


import app.movida.business.entity.Actor;
import app.movida.business.entity.Site;
import app.movida.business.svc.ActorService;
import app.movida.business.svc.SiteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/sites")
public class SiteController {
    private final SiteService siteService;

    @GetMapping
    public String listSites(Model model) {
        List<Site> sites = siteService.searchALl(); // 전체 조회
        model.addAttribute("sites", sites);
        return "sites";
    }


    @PostMapping(value="/ins")
    public String getPhoto(@ModelAttribute Site site) throws IOException {
        log.info("site: {}", site);

        siteService.ins(site);

        return "redirect:/sites";
    }
}
