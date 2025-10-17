package app.movida.business.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/system")
public class SystemTestCtl {
    @RequestMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
