package io.romani.textservice.textservice.services;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

public abstract class WordGeneratorService implements TextGeneratorService {

    @Value("${words}")
    private String words;

    public String generate() {
        String[] splitWords = words.split(",");
        int index = new Random().nextInt(splitWords.length);
        return splitWords[index];
    }
}
