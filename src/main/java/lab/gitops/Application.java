package lab.gitops;

import java.time.Instant;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class HelloController {
    private final String greeting;

    HelloController(@Value("${app.greeting:Hello from the application}") String greeting) {
        this.greeting = greeting;
    }

    @GetMapping("/")
    Map<String, Object> home() {
        return Map.of(
            "app", "java-api",
            "message", greeting,
            "time", Instant.now().toString()
        );
    }
}
