create table admin
(
    id            integer not null,
    national_code varchar not null
);

alter table admin
    owner to postgres;

INSERT INTO public.admin (id, national_code) VALUES (1, '123456789');
