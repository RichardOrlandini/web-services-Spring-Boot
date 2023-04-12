package com.richardorlandini.curse.config;

import com.richardorlandini.curse.entities.User;
import com.richardorlandini.curse.repositoryes.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // nome deve ser igual no aplication-test.properties
public class TesteConfig implements CommandLineRunner {

    //para fazer um objj dependender de outro.(injeção de dependencia)
    @Autowired //o proprio Spring resolve a dependecia associando uma instancia do UserRepository
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

    }


}
