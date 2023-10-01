package academy.wakanda.sorrileadsbe.application.api;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Id;
import java.util.UUID;
@Value
@Builder
public class RespondentResponse {
    @Id
    private UUID idRespondent;
}
