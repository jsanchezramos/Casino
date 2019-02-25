package runable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import services.CasinoGame;

import java.util.Scanner;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"services"})
@EntityScan("model.entity")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"repository"})
public class Casino implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(Casino.class);

    private CasinoGame casinoGame;
    @Autowired
    public Casino(CasinoGame casinoGame) {
        this.casinoGame = casinoGame;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Casino.class, args);
    }

    @Override
    public void run(String... args)  {
        Scanner keyboard = new Scanner(System.in);
        String continueBingo = null;
        LOG.info("----- Bienvenido al casino -------- ");
        do{
            LOG.info(" Seleciona que juego quieres jugar \n 1-VIDEOBINGO \n 2-SLOT \n 3-LACKJACK \n 4-POKER \n 5-RULETA ");

            String valueGame = keyboard.next();
            LOG.info("Cuanto quieres apostar? ");
            String valueBet = keyboard.next();
            casinoGame.startGame(Integer.parseInt(valueGame),Integer.parseInt(valueBet));

            LOG.info("Pulsa el numero 1 para continuar, en caso contrario pulsa cualquier otra tecla ");
            continueBingo = keyboard.next();
        }while(continueBingo.equals("1"));

    }
}

