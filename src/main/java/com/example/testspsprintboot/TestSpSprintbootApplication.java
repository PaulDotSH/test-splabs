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

@SpringBootApplication
public class TestSpSprintbootApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Message> messages = new ObjectMapper().readValue(new URL("file:src/messages.json"), new TypeReference<List<Message>>(){});
        Atreides atreides = new Atreides();
        Harkonnen harkonnen = new Harkonnen();

        for (Message m : messages) {
            if (Objects.equals(m.house, "atreides")) {
                System.out.println("Mesaj de la casa Atreides, trimis la " + m.date);
                System.out.println(atreides.decode(m));
            } else if (Objects.equals(m.house, "harkonnen")) {
                System.out.println("Mesaj de la casa Harkonnen, trimis la " + m.date);
                System.out.println(harkonnen.decode(m));
            }
        }

//        SpringApplication.run(TestSpSprintbootApplication.class, args);
    }

    public static String makeUppercase(String s) {
        return s.isEmpty() ? s : s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
