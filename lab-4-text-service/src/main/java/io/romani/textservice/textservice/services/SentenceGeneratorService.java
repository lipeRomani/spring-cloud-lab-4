package io.romani.textservice.textservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
@Profile("sentence")
@Primary
public class SentenceGeneratorService implements TextGeneratorService {

    private DiscoveryClient discoveryClient;

    @Autowired
    public SentenceGeneratorService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public String generate() {
        return getWord("LAB-4-TEXT-SERVICE-SUBJECT") +
                " " +
                getWord("LAB-4-TEXT-SERVICE-VERB") +
                " " +
                getWord("LAB-4-TEXT-SERVICE-ARTICLE") +
                " " +
                getWord("LAB-4-TEXT-SERVICE-ADJECTIVE") +
                " " +
                getWord("LAB-4-TEXT-SERVICE-NOUN");
    }

    private String getWord(String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);

        if (instances == null || instances.size() == 0) {
            return null;
        }

        URI uri = instances.get(0).getUri();

        if (uri == null) {
            return  null;
        }

        return new RestTemplate().getForObject(uri, String.class);
    }
}
