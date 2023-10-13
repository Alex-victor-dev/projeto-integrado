package academy.wakanda.sorrileadsbe.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FormJson {
   private String form_name;
   private String form_id;
}