package app.springbootproj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor

public class JellyBean {

    JellyBean(){}
    JellyBean(String color, String flavor,String id){
        this.color = color;
        this.flavor = flavor;
        this.id = id;
    }
    private String color;
    private String flavor;
    private String id;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}