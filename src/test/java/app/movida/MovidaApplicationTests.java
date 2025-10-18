package app.movida;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.config.server.config.ConfigServerAutoConfiguration;

@SpringBootTest
@EnableAutoConfiguration(exclude = {
        ConfigServerAutoConfiguration.class,
        // 필요하다면, Config Client 자동 설정도 제외
        // ConfigServicePropertySourceLocator.class
})
class MovidaApplicationTests {

    @Test
    void contextLoads() {
    }

}
