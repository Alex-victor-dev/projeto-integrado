package academy.wakanda.sorrileadsbe.clinic.application.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebhookService {
    private static final String BASE_URL = "http://ec2-34-227-66-235.compute-1.amazonaws.com:8080/sorrileads/v1/lead/";

    public String generateWebhookUrl(UUID idClinic) {
        return BASE_URL + idClinic.toString();
    }
}
