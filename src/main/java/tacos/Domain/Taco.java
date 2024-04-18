package tacos.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull()
    @Size(min = 1, message = "You must choose at least one ingredient")

    private Date createdAt = new Date();

    @ManyToMany
    private List<Ingredient> ingredients;
}
