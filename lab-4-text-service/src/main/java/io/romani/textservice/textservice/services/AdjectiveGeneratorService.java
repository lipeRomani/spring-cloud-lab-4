package io.romani.textservice.textservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("adjective")
@Primary
public class AdjectiveGeneratorService extends WordGeneratorService {
}
