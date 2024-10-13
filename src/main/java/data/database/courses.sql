create table courses
(
    course_id    serial
        primary key,
    course_title varchar(50) not null,
    course_unit  integer     not null
);

alter table courses
    owner to postgres;

INSERT INTO public.courses (course_id, course_title, course_unit) VALUES (11, 'history', 2);
INSERT INTO public.courses (course_id, course_title, course_unit) VALUES (12, 'geography', 2);
INSERT INTO public.courses (course_id, course_title, course_unit) VALUES (13, 'english', 1);
INSERT INTO public.courses (course_id, course_title, course_unit) VALUES (10, 'math', 3);
INSERT INTO public.courses (course_id, course_title, course_unit) VALUES (17, 'python', 3);
