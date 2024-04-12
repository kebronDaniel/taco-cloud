package tacos.Domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {

    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull()
    @Size(min = 1, message = "You must choose at least one ingredient")
    private List<Ingredient> ingredients;
}
