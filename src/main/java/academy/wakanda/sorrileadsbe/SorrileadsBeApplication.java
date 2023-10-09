package academy.wakanda.sorrileadsbe;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@Log4j2
public class SorrileadsBeApplication {

	@GetMapping("/")
	public String testHome() {
		log.info("[start] SorrileadsBeApplication - testHome");
		String home = "home sorrileads";
		log.info("[finish] SorrileadsBeApplication - testHome");
		return home;
	}

	public static void main(String[] args) {
		SpringApplication.run(SorrileadsBeApplication.class, args);
	}

}
