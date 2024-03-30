package tacos.Domain;

import lombok.Data;

import java.util.List;

@Data
public class Taco {

    private String id;
    private String name;

    private List<Ingredient> ingredients;
}
