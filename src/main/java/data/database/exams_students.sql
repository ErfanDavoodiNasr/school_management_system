create table exams_students
(
    id         serial
        primary key,
    student_id integer
        references students,
    exam_id    integer
        references exams
);

alter table exams_students
    owner to postgres;

