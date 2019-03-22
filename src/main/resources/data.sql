

create sequence if not exists hibernate_sequence start with 1 increment by 1;
create table if not exists user (id integer not null, birth_date timestamp, name varchar(255), primary key (id));

insert into user values (1, sysdate(), 'Zombie');
insert into user values (2, sysdate(), 'The Cranberries');
insert into user values (3, sysdate(), 'Shakira');

create table if not exists post (id integer not null, description varchar(255), user_id integer, primary key (id));
alter table post add constraint fk_user_id foreign key (user_id) references user;

insert into post values (1000, 'first post', 3);
insert into post values (1001, 'second post', 3);
insert into post values (1002, 'first post', 1);
