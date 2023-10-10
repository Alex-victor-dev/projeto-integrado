package academy.wakanda.sorrileadsbe.application.api;

import lombok.Builder;
import lombok.Value;
import java.util.UUID;
@Value
@Builder
public class LeadResponse {
    private UUID idLead;
}
