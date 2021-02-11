drop table if exists authorization_session cascade;
drop table if exists authorizaton_session cascade;
drop table if exists electricity cascade;
drop table if exists payment cascade;
drop table if exists user_authorization cascade;
drop table if exists user_authorization_session cascade;
drop table if exists userinfo cascade;
drop table if exists water cascade;

create table if not exists authorization_session (
                                       user_id int unique,
                                       session_id varchar not null,
                                       expired_date date
);

create table if not exists electricity (
                             user_id int unique,
                             id int,
                             dayElectricity varchar,
                             nightElectricity varchar,
                             electricityDate date
);

create table if not exists payment (
                         user_id int unique,
                         id int,
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
                       user_id int unique,
                       id int,
                       hot varchar,
                       cold varchar,
                       dateWater date
);

create table if not exists user_authorization (
                                       user_id int unique,
                                       login varchar not null unique,
                                       password varchar not null

);


ALTER TABLE "user_authorization" ADD FOREIGN KEY ("user_id") REFERENCES "userinfo" ("id");

ALTER TABLE "electricity" ADD FOREIGN KEY ("user_id") REFERENCES "userinfo" ("id");

ALTER TABLE "water" ADD FOREIGN KEY ("user_id") REFERENCES "userinfo" ("id");

ALTER TABLE "payment" ADD FOREIGN KEY ("user_id") REFERENCES "userinfo" ("id");

ALTER TABLE "authorization_session" ADD FOREIGN KEY ("user_id") REFERENCES "user_authorization" ("user_id");

insert into userinfo
 values(1,'Ivan', 'Ivanov', 'Ivanovich','231');

 insert into user_authorization
  values(1,'admin', '$2a$10$Gba75slGdo4d/FcNqUx/guI.h1IvyIH.nfwsgDvT7MZYmv2a.h9Cm');

insert into electricity
 values(1,'23','12','12-01-2021');

insert into payment
 values(1,'2345','12-01-2021');


insert into water
 values(1,'234','123','12-01-2021');

