create table exams
(
    exam_id    serial
        primary key,
    course_id  integer     not null
        references courses,
    exam_title varchar(50) not null,
    exam_date  date,
    exam_time  time
);

alter table exams
    owner to postgres;

INSERT INTO public.exams (exam_id, course_id, exam_title, exam_date, exam_time) VALUES (6, 10, 'math', '2024-10-06', '21:13:21');
INSERT INTO public.exams (exam_id, course_id, exam_title, exam_date, exam_time) VALUES (7, 11, 'history', '2024-10-22', '21:09:28');
INSERT INTO public.exams (exam_id, course_id, exam_title, exam_date, exam_time) VALUES (8, 12, 'geography', '2024-10-16', '18:15:25');
INSERT INTO public.exams (exam_id, course_id, exam_title, exam_date, exam_time) VALUES (9, 13, 'english', '2024-10-01', '08:13:30');
INSERT INTO public.exams (exam_id, course_id, exam_title, exam_date, exam_time) VALUES (12, 17, 'python', '2005-01-22', '01:30:00');
