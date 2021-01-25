-- Copy table
create table user_authorization_session (like authorization_session including all);
insert into user_authorization_session select * from authorization_session;

--
---- Change constraints
--alter table userinfo
--    alter column first_name set not null;
--
--alter table userinfo
--    alter column last_name set not null;
--
--alter table userinfo
--    alter column flat set not null;
--
---- Drop table
--drop table sessions;