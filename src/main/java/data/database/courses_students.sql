create table courses_students
(
    id         serial
        primary key,
    course_id  integer not null
        references courses,
    student_id integer not null
        references students,
    avg_score  double precision default 0.0
);

alter table courses_students
    owner to postgres;

INSERT INTO public.courses_students (id, course_id, student_id, avg_score) VALUES (30, 17, 70, 0);
INSERT INTO public.courses_students (id, course_id, student_id, avg_score) VALUES (33, 12, 70, 2);
INSERT INTO public.courses_students (id, course_id, student_id, avg_score) VALUES (32, 12, 69, 15);
INSERT INTO public.courses_students (id, course_id, student_id, avg_score) VALUES (31, 17, 69, 13);
INSERT INTO public.courses_students (id, course_id, student_id, avg_score) VALUES (28, 11, 69, 20);
INSERT INTO public.courses_students (id, course_id, student_id, avg_score) VALUES (29, 11, 70, 20);
