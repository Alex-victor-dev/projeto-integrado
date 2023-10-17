package academy.wakanda.sorrileadsbe.application.api;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormJson {
   private String form_name;
   private String form_id;
}