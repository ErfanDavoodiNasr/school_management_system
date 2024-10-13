create table students
(
    student_id    serial
        primary key,
    first_name    varchar(50) not null,
    last_name     varchar(50) not null,
    birth_date    date,
    entry_date    date,
    phone_number  varchar(15),
    national_code varchar(10) not null,
    avg_score     double precision default 0.0
);

alter table students
    owner to postgres;

INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (71, 'ahmad', 'ebrahimi', '2001-10-09', '2024-10-07', '09113905929', '918273645', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (72, 'mohsen', 'jalili', '1994-10-04', '2024-10-07', '09115905929', '193546782', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (73, 'kiavash', 'khaksar', '1987-10-07', '2024-10-07', '09116905920', '196389264', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (74, 'ali', 'saravi', '2004-05-22', '2024-10-07', '0912374274', '129634825', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (78, 'sara', 'bahrami', '2002-06-26', '2024-10-11', '09358194725', '12742141', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (80, 'aaa', 'bbb', null, null, null, '1265313', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (81, 'aaa', 'bbb', null, null, null, '1265313', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (82, 'aaa', 'bbb', null, null, null, '1265313', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (83, 'aaa', 'bbb', null, null, null, '1265313', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (84, 'agha', 'toto jazab', '2011-11-29', '2024-10-13', '09353527423', '62621412', 11.25);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (69, 'ali', 'najafi', '2012-10-09', '2024-10-07', '09111905929', '87654321', 16);
INSERT INTO public.students (student_id, first_name, last_name, birth_date, entry_date, phone_number, national_code, avg_score) VALUES (70, 'javad', 'moradi', '2008-10-16', '2024-10-07', '09112905929', '192837465', 7.333333333333333);
