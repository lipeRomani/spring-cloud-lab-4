package io.romani.sentence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class GetSentenceController {

    private DiscoveryClient discoveryClient;

    @Autowired
    public GetSentenceController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/sentence")
    public String getSentence() {
        return new StringBuilder()
                .append(getWord("LAB-4-SUBJECT"))
                .append(" ")
                .append(getWord("LAB-4-VERB"))
                .append(" ")
                .append(getWord("LAB-4-ARTICLE"))
                .append(" ")
                .append(getWord("LAB-4-ADJECTIVE"))
                .append(" ")
                .append(getWord("LAB-4-NOUN"))
                .toString();
    }

    private String getWord(String service) {
        List<ServiceInstance> clientInstances = discoveryClient.getInstances(service);

        if (clientInstances == null || clientInstances.size() == 0) {
            return null;
        }

        URI uri = clientInstances.get(0).getUri();

        if (uri == null) {
            return null;
        }

        return (new RestTemplate()).getForObject(uri, String.class);
    }
}
