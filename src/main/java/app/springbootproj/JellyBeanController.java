package app.springbootproj;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> getallBeans() {
        String myBeans = jellyBeanService.getAll();
        return new ResponseEntity<>(myBeans, HttpStatus.OK);
    }

    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    @PostMapping("/")
    public ResponseEntity<JellyBean> createBean() {
        UUID newUUID = UUID.randomUUID();
        String color = "red";
        String flavor = "banana";
        JellyBean jellyBean = new JellyBean(newUUID, color, flavor);
        jellyBeanService.add(jellyBean);
        return new ResponseEntity<>(jellyBean, HttpStatus.OK);
        // return new ResponseEntity<>("Jelly Bean has been crreated" + jellyBean, HttpStatus.OK);

    }

    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    @PostMapping("/update/{id}")
    public JellyBean replaceBean(@PathVariable String id) {
        JellyBean jellyBean = null;
        String color = "yellow";
        String flavor = "popcorn";
        if (id == jellyBeanService.getbyId(id)) {
            jellyBean = new JellyBean(id, color, flavor);
            jellyBeanService.add(jellyBean);
        }
        return jellyBean;
    }

    // TODO: Return a ResponseEntity here as well and change the parameter to a UUID
    public ResponseEntity<String> getBeanbyId(@PathVariable String id) {
        if (id == jellyBeanService.getbyId(id)) {
            System.out.println("ID has been found");
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
