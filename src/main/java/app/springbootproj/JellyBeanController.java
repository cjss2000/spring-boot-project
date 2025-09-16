package app.springbootproj;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSOutput;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/jellybeans/")
public class JellyBeanController {

    JellyBeanServiceImpl js = new JellyBeanServiceImpl();
    private final JellyBeanService jellyBeanService;

    @GetMapping("/allbeans")
    ResponseEntity<String> getallBeans() {
        String myBeans = js.getAll();
        return new ResponseEntity<>(myBeans, HttpStatus.OK);
    }

    @PostMapping("/jellybeans")
    ResponseEntity<JellyBean> createBean() {
        UUID newUUID = UUID.randomUUID();
        String color = "red";
        String flavor = "banana";
        JellyBean jellyBean = new JellyBean(newUUID, color, flavor);
        js.add(jellyBean);
        return new ResponseEntity<>(jellyBean, HttpStatus.OK);
        // return new ResponseEntity<>("Jelly Bean has been crreated" + jellyBean, HttpStatus.OK);

    }

        @PostMapping("/replacebean/{id}")
    public JellyBean replaceBean(@PathVariable String id){
        JellyBean jellyBean = null;
        String color = "yellow";
        String flavor = "popcorn";
        if (id == jellyBeanService.getbyId(id)) {
            jellyBean = new JellyBean(id, color, flavor);
            jellyBeanService.add(jellyBean);
        }
    return jellyBean;
    }
    @GetMapping("/jellybeans/{id}")
    ResponseEntity<String> getBeanbyId(@PathVariable String id) {
        if (id == js.getbyId(id)) {
            System.out.println("ID has been found");
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/hello")
    ResponseEntity<String> printHello() {
        return new ResponseEntity<>("Howdy Partner!", HttpStatus.OK);
    }
}
