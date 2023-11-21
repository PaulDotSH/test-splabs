package com.example.testspsprintboot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

// Stiu ca se putea implementa un strategy pattern dar asa este mai rapid, initializand casele doar o data in main, preferabil ar fi fost sa folosim reflection sa initializam casele si sa le punem intr-un hashmap sa fie mai putin cod, dar nu putem lua la runtime usor toate clasele derivate dintr-o clasa
@SpringBootApplication
public class TestSpSprintbootApplication {

    public static void main(String[] args) throws IOException {
        List<Message> messages = new ObjectMapper().readValue(new URL("file:src/messages.json"), new TypeReference<List<Message>>(){});
        Atreides atreides = new Atreides();
        Harkonnen harkonnen = new Harkonnen();

        for (Message m : messages) {
            if (Objects.equals(m.house, "atreides")) {
                System.out.println("Atreides, trimis la " + m.date);
                System.out.println("Mesaj: " + atreides.decode(m));
            } else if (Objects.equals(m.house, "harkonnen")) {
                System.out.println("Harkonnen, trimis la " + m.date);
                System.out.println("Mesaj: " + harkonnen.decode(m));
            } else {
                System.out.println("Mesaj indescifrabil (de la casa " + m.house + "), trimis la " + m.date);
            }
        }

//        SpringApplication.run(TestSpSprintbootApplication.class, args);
    }

    public static String makeUppercase(String s) {
        return s.isEmpty() ? s : s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
