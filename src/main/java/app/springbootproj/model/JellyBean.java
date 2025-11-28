package app.springbootproj.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jellybeans")
public class JellyBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String color;
    private String flavor;

}