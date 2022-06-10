package br.com.animais.repository;

import br.com.animais.model.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AnimaisRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Animal("Leão", "Panthera leo",120.0)));
            log.info("Preloading " + repository.save(new Animal("Onça", "Panthera onca",80.0)));
        };
    }
}