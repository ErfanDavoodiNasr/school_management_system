package ir.ncttrade;

import ir.ncttrade.model.Course;
import ir.ncttrade.repository.impl.CourseRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Course c1 = Course.builder()
                .courseTitle("python")
                .courseUnit(5)
                .build();

        CourseRepositoryImpl cr = new CourseRepositoryImpl();

    }
}
