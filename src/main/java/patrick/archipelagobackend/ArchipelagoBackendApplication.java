package patrick.archipelagobackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("patrick.archipelagobackend.mapper")
public class ArchipelagoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArchipelagoBackendApplication.class, args);
    }

}
