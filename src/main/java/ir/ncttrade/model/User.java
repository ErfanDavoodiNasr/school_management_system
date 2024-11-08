package ir.ncttrade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import ir.ncttrade.base.BaseModel;
import ir.ncttrade.model.embeddable.Address;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "users")
public class User<ID extends Serializable> extends BaseModel<ID> implements Serializable {
    @Column(name = "first_name" , nullable = false, columnDefinition = "varchar(50) default ''")
    private String firstName;
    @Column(name = "last_name" , nullable = false)
    private String lastName;
    @Column(name = "national_code" , nullable = false, unique = true)
    private String nationalCode;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "entry_date")
    private LocalDate entryDate;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "address")
    @Embedded
    private Address address;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "father_name")
    private String fatherName;
}
