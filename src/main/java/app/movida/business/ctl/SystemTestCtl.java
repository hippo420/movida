package app.movida.business.ctl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/system")
public class SystemTestCtl {
    @RequestMapping("/health")
    public String healthCheck() {
        log.info("Health check started");
        return "OK";
    }
}
