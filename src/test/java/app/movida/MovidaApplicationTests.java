package app.movida;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.config.server.config.ConfigServerAutoConfiguration;

@SpringBootTest
@EnableAutoConfiguration(exclude = {ConfigServerAutoConfiguration.class})
class MovidaApplicationTests {

    @Test
    void contextLoads() {
    }

}
