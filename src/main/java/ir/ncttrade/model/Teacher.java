package ir.ncttrade.model;

import ir.ncttrade.base.BaseModel;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "teachers")
public class Teacher extends BaseModel<Integer> {
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
    private String address;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "father_name")
    private String fatherName;
    @OneToOne
    @JoinColumn(
            name = "fk_course_id"
    )
    private Course course;
}
