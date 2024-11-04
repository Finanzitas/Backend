package upc.efinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EFinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EFinanceApplication.class, args);
    }

}

