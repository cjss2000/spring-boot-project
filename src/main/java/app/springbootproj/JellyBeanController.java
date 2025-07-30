package app.springbootproj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JellyBeanController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
