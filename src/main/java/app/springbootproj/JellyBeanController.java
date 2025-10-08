package app.springbootproj;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/jellybeans/")
public class JellyBeanController {

    private final JellyBeanService jellyBeanService;

    // TODO: Controllers should be returning ResponseEntity obeject, take a look at this article: https://www.baeldung.com/spring-response-entity
    // and adjust your endpoints accordingly //

    @GetMapping("/")
    public List<JellyBean> getallBeans() {
        return jellyBeanService.getAll();
    }

    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    @PostMapping("/")
    public JellyBean createBean(@RequestBody JellyBean jellyBean) {
      //  String newUUID = UUID.randomUUID().toString();
        UUID newUUID = UUID.randomUUID();
        jellyBean.setId(newUUID);
        jellyBeanService.add(jellyBean);
        return jellyBean;

    }


    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    @PostMapping("/update/{id}")
    public JellyBean replaceBean(@RequestBody JellyBean jellyBean, @PathVariable UUID id) {
        JellyBean tempBean = jellyBeanService.getById(id);
        if (tempBean == null){
            return null;
        }
        tempBean.setColor(jellyBean.getColor());
        tempBean.setFlavor(jellyBean.getFlavor());
        return tempBean;
    }

    // TODO: Return a ResponseEntity here as well
    @GetMapping("/{id}")
    public UUID getBeanbyId(@PathVariable UUID id) {
        if (id.equals(jellyBeanService.getById(id))) {
            System.out.println("ID has been found");
        }
        return id;
    }

}
