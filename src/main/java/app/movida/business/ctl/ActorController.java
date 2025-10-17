package app.movida.business.ctl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import app.movida.business.entity.Actor;
import app.movida.business.svc.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import static app.movida.system.util.FileCompressUtil.compressImage;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    @GetMapping
    public String listActors(@RequestParam(required = false,name ="name") String name, Model model) {
        List<Actor> actors = (name != null)
                ? actorService.searchByName(name)
                : actorService.searchByName(""); // 전체 조회
        model.addAttribute("actors", actors);
        return "actors";
    }

    @GetMapping("/{id}/photo")
    public ResponseEntity<byte[]> getPhoto(@PathVariable Long id) throws IOException {
        Actor actor = actorService.getActor(id).orElseThrow();
        //byte[] photo = compressImage(actor.getPhoto());
        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg")
                .body(null);
    }

    @PostMapping(value="/ins", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String getPhoto(@ModelAttribute Actor actor,
                           @RequestParam(value="photo", required=false) MultipartFile photo) throws IOException {
        log.info("actor: {}", actor);
//        if (photo != null && !photo.isEmpty()) {
//            actor.setPhoto(photo.getBytes());
//        }
        actorService.ins(actor);

        return "redirect:/actors";
    }
}
