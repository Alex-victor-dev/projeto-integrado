package academy.wakanda.sorrileadsbe.application.api;

import lombok.*;
import java.util.UUID;

@Value
@Builder
public class LeadResponse {
    private UUID idLead;
}