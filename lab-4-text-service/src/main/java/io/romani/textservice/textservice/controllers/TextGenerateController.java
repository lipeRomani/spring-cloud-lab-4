package io.romani.textservice.textservice.controllers;

import io.romani.textservice.textservice.services.TextGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextGenerateController {

    private TextGeneratorService generatorService;

    @Autowired
    public TextGenerateController(TextGeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping("/")
    public String generate() {
        return  generatorService.generate();
    }
}
