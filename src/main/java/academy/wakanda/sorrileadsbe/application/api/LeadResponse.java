package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.Lead;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeadResponse {
    private UUID idLead;

    public LeadResponse (Lead lead){
        this.idLead = lead.getIdLead();
    }
}