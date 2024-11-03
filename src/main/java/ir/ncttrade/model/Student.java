package ir.ncttrade.model;

import javax.persistence.*;
import java.time.LocalDate;

import ir.ncttrade.base.BaseModel;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "students")
public class Student extends BaseModel<Integer> {
    @Column(name = "first_name" , nullable = false, columnDefinition = "varchar(50) default ''")
    private String firstName;
    @Column(name = "last_name" , nullable = false)
    private String lastName;
    @Column(name = "national_code" , nullable = false, unique = true)
    private String nationalCode;
    @Column(name = "field")
    private String field;
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
