package ir.ncttrade.model;


import ir.ncttrade.base.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Table(name = "exams")
public class Exam extends BaseModel<Integer> {
    @Column(name = "exam_title")
    private String examTitle;
    @Column(name = "exam_date")
    private LocalDate examDate;
    @Column(name = "exam_time")
    private LocalTime examTime;
    @ManyToOne
    @JoinColumn(
            name = "fk_course_id"
    )
    private Course course;
}
