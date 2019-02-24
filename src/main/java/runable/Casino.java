package runable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Casino implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(Casino.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Casino.class, args);
    }

    @Override
    public void run(String... args)  {
        LOG.info("----- Bienvenido al casino -------- ");
        Scanner keyboard = new Scanner(System.in);
        LOG.info(" has apretado "+ keyboard.next());
    }
}

