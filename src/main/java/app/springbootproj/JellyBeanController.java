package app.springbootproj;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/jellybeans/")
public class JellyBeanController {

JellyBeanServiceImpl js = new JellyBeanServiceImpl();

    @GetMapping("/jellybeans")
    public String getallBeans(){
        String myBeans = js.getAll().toString();
        return myBeans;


    }

    @PostMapping("/jellybeans")
    public JellyBean createBean() {
        String newUUID = UUID.randomUUID().toString();
        String color = "red";
        String flavor = "banana";
        JellyBean jellyBean = new JellyBean(newUUID, color, flavor);
      //  jellyBean.setId(UUID.randomUUID().toString());
        js.add(jellyBean);
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
