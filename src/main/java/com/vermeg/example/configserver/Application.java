package com.vermeg.example.configserver;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.EnvironmentRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Thomas Demande
 */

@ComponentScan
@EnableAutoConfiguration
@Configuration
@EnableConfigServer
public class Application implements InitializingBean{

    @Autowired
    private EnvironmentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        repository.findOne("bootstrap", null, "master");
    }
}
