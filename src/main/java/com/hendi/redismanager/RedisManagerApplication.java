package com.hendi.redismanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RedisManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisManagerApplication.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MusicService musicService = ctx.getBean(MusicService.class);

        System.out.println("message: " + musicService.play("trumpet"));
        System.out.println("message: " + musicService.play("trumpet"));
        System.out.println("message: " + musicService.play("guitar"));
        System.out.println("message: " + musicService.play("guitar"));

        System.out.println("Done.");
    }
}
