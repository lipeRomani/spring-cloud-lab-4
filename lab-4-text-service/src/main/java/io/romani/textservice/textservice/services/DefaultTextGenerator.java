package io.romani.textservice.textservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class DefaultTextGenerator implements TextGeneratorService {

    @Override
    public String generate() {
        return "choose an profile";
    }
}
