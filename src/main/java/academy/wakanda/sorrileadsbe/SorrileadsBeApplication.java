package academy.wakanda.sorrileadsbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SorrileadsBeApplication {
	@GetMapping
	public String getHomeTeste(){
		return "Sorrileads - API Home";
	}

	public static void main(String[] args) {
		SpringApplication.run(SorrileadsBeApplication.class, args);
	}

}
