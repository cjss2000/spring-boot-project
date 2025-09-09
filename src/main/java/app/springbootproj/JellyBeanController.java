package app.springbootproj;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/jellybeans/")
public class JellyBeanController {

JellyBeanServiceImpl js = new JellyBeanServiceImpl();

    @GetMapping("/allbeans")
    public String getallBeans(){
        String myBeans = js.getAll();
        return myBeans;


    }

    @PostMapping("/jellybeans")
    public JellyBean createBean() {
        String newUUID = UUID.randomUUID().toString();
        String color = "red";
        String flavor = "banana";
        JellyBean jellyBean = new JellyBean(newUUID, color, flavor);
        js.add(jellyBean);
        return jellyBean;

    }
    @PostMapping("/replacebean/{id}")
    public JellyBean replaceBean(@PathVariable String id){
        JellyBean jellyBean = null;
            String color = "yellow";
            String flavor = "popcorn";
        if (id == js.getbyId(id)){
            jellyBean = new JellyBean(id, color, flavor);
            js.add(jellyBean);
        }
    return jellyBean;
    }
    @GetMapping("/jellybeans/{id}")
    public String getBeanbyId(@PathVariable String id){
        if (id == js.getbyId(id)){
            System.out.println("ID has been found");
        }
        return id;
    }

    @GetMapping("/hello")
        public String printHello(){
      return "hello";
    }
}
