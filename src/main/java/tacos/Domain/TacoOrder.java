package tacos.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Delivery street is required")
    private String deliveryStreet;

    @NotBlank(message = "Delivery city is required")
    private String deliveryCity;

    @NotBlank(message = "Delivery state is required")
    private String deliveryState;

    @NotBlank(message = "Delivery zip is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid Credit Card Number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(fraction = 0, integer = 3, message = "Invalid CVV")
    private Integer ccCVV;

    private Date placedAt = new Date();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTacos(Taco taco) {
        this.tacos.add(taco);
    }
}
