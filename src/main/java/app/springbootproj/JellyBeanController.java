package app.springbootproj;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/jellybeans/")
public class JellyBeanController {

    private final JellyBeanService jellyBeanService;

    // TODO: Controllers should be returning ResponseEntity obeject, take a look at this article: https://www.baeldung.com/spring-response-entity
    // and adjust your endpoints accordingly
    @GetMapping("/")
    public String getallBeans() {
        String myBeans = jellyBeanService.getAll().toString();
        return myBeans;
    }

    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    @PostMapping("/")
    public JellyBean createBean() {
      //  String newUUID = UUID.randomUUID().toString();
        UUID newUUID = UUID.randomUUID();
        String color = "red";
        String flavor = "banana";
        JellyBean jellyBean = new JellyBean(newUUID, color, flavor);
        jellyBeanService.add(jellyBean);
        return jellyBean;

    }

    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    @PostMapping("/update/{id}")
    public JellyBean replaceBean(@PathVariable String id) {
        JellyBean jellyBean = null;
        String color = "yellow";
        String flavor = "popcorn";

        UUID uuid = UUID.fromString(id);

        if (uuid.equals(jellyBeanService.getbyId(uuid))) {
            jellyBean = new JellyBean(uuid, color, flavor);
            jellyBeanService.add(jellyBean);
        }
        return jellyBean;
    }

    // TODO: Return a ResponseEntity here as well
    @GetMapping("/{id}")
    public UUID getBeanbyId(@PathVariable UUID id) {
        if (id.equals(jellyBeanService.getbyId(id))) {
            System.out.println("ID has been found");
        }
        return id;
    }

}
