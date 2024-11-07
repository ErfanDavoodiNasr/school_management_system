package ir.ncttrade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embeddable;

@Embeddable
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String country;
    private String city;
    private String address;
    private String zipCode;
}
