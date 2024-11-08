package ir.ncttrade.model;

import javax.persistence.*;

import ir.ncttrade.model.enums.Field;
import lombok.*;
import lombok.experimental.SuperBuilder;
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
public class Student extends User<Integer> {
    @Enumerated(EnumType.STRING)
    @Column(name = "field")
    private Field field;
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
