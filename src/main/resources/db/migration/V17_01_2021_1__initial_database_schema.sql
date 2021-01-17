create table if not exists authorization_session (
                                       user_id int primary key,
                                       session_id varchar not null,
                                       expired_date date
);

create table if not exists electricity (
                             id int primary key,
                             dayElectricity varchar,
                             nightElectricity varchar,
                             electricityDate date
);

create table if not exists payment (
                         id int primary key,
                         debt varchar,
                         paymentDate date
);

create table if not exists userinfo (
                          id serial primary key,
                          first_name varchar,
                          last_name varchar,
                          middle_name varchar,
                          flat varchar
);

create table if not exists water (
                       id int primary key,
                       hot varchar,
                       cold varchar,
                       dateWater date
);

create table if not exists authorization_session (
                                       user_id int primary key,
                                       session_id int

)