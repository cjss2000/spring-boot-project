package app.springbootproj.controller;

import app.springbootproj.model.JellyBean;
import app.springbootproj.service.JellyBeanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/jellybeans")
public class JellyBeanController {

    private final JellyBeanService jellyBeanService;

    // TODO: Controllers should be returning ResponseEntity obeject, take a look at this article: https://www.baeldung.com/spring-response-entity
    // and adjust your endpoints accordingly
    @GetMapping
    public ResponseEntity<List<JellyBean>> getAllBeans() {
        return ResponseEntity.ok(jellyBeanService.getAll());
    }

    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    @PostMapping
    public ResponseEntity<JellyBean> createBean(@RequestBody JellyBean jellyBean) {
        jellyBeanService.createOrUpdate(jellyBean);
        return ResponseEntity.ok(jellyBean);
    }


    // TODO: Return a ResponseEntity here as well + accept @RequestBody - a JellyBean object in the parameters to this method
    // TODO: extract the update logic into a separate service method called update
    @PostMapping("/update/{id}")
    public ResponseEntity<JellyBean> replaceBean(@RequestBody JellyBean jellyBean, @PathVariable UUID id) {
        JellyBean tempBean = jellyBeanService.getById(id);
        if (tempBean == null){
            return null;
        }
        tempBean.setColor(jellyBean.getColor());
        tempBean.setFlavor(jellyBean.getFlavor());
        jellyBeanService.createOrUpdate(tempBean);
        return ResponseEntity.ok(tempBean);
    }

    // TODO: Return a ResponseEntity here as well
    @GetMapping("/{id}")
    public ResponseEntity<UUID> getBeanById(@PathVariable UUID id) {
        if (id.equals(jellyBeanService.getById(id))) {
            System.out.println("ID has been found");
        }
        return ResponseEntity.ok(id);
    }

}
