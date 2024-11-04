package ir.ncttrade.model;

import ir.ncttrade.base.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Table(name = "courses")
public class Course extends BaseModel<Integer> {
    @Column(name = "course_title")
    private String courseTitle;
    @Column(name = "course_unit")
    private Integer courseUnit;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "j_courses_student",
            joinColumns = {@JoinColumn(name = "fk_course_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_student_id")}
    )
    private List<Student> students = new ArrayList<>();
}
