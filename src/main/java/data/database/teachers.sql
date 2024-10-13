create table teachers
(
    teacher_id    serial
        primary key,
    first_name    varchar(50),
    last_name     varchar(50),
    birth_date    date,
    entry_date    date,
    phone_number  varchar(15),
    national_code varchar(15),
    course_id     integer
        references courses
);

alter table teachers
    owner to postgres;

INSERT INTO public.teachers (teacher_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, course_id) VALUES (23, 'reza', 'ebrahimi', '2003-10-08', '2024-10-07', '09112738475', '12764212415', 10);
INSERT INTO public.teachers (teacher_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, course_id) VALUES (24, 'ali', 'moradi', '1993-07-13', '2024-10-07', '09354758989', '0127546145', 12);
INSERT INTO public.teachers (teacher_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, course_id) VALUES (31, 'mahommad', 'mohammadi', null, null, null, '134234234234', 17);
INSERT INTO public.teachers (teacher_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, course_id) VALUES (20, 'reza', 'noori', '2000-10-10', '2024-10-07', '09123648736', '1', 11);
