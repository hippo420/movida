package app.movida.system.util.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseConnectionChecker implements CommandLineRunner {

    // application.properties에 설정된 spring.datasource.url 값을 주입받습니다.
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;


    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==================================================");
        System.out.println("🔍 설정된 MySQL 데이터베이스 연결 URL 확인:");
        System.out.println("✅URL     : " + databaseUrl);
        System.out.println("✅USERNAME: " + username   );
        System.out.println("✅PASSWORD: " + password   );
        System.out.println("✅DRIVER  : " + driver     );
        System.out.println("✅DIALECT : " + dialect    );
        System.out.println("==================================================");
    }
}
