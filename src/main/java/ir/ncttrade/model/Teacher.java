package ir.ncttrade.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Table(name = "teachers")
public class Teacher extends User<Integer> {
    @OneToOne
    @JoinColumn(
            name = "fk_course_id"
    )
    private Course course;
}
