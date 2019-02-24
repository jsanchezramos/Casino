package runable;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = {"services"})
@EntityScan("model.entity")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"repository"})
public class CasinoTest {
}

