package ir.ncttrade.model;

import javax.persistence.*;
import java.time.LocalDate;

import ir.ncttrade.base.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Table(name = "students")
@NamedQuery(name = "Student.findByNationalCode", query = "SELECT s FROM Student s WHERE s.nationalCode = ?1")
public class Student extends BaseModel<Integer> {
    @Column(name = "first_name" , nullable = false, columnDefinition = "varchar(50) default ''")
    private String firstName;
    @Column(name = "last_name" , nullable = false)
    private String lastName;
    @Column(name = "national_code" , nullable = false, unique = true)
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "field")
    private Field field;
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
    @Column(name = "average_score")
    private Double averageScore;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "j_students_exams",
            joinColumns = {@JoinColumn(name = "fk_student_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_exam_id")}
    )
    private List<Exam> exam = new ArrayList<>();
}
