-- all queries should be written in one line

insert into roles (id, created_at, name) values (1, now(), 'ADMIN');
insert into roles (id, created_at, name) values (2, now(), 'USER');

insert into users (id, created_at, username, first_name, last_name, password) values (1, now(), 'admin', 'admin_fn', 'admin_ln', 'password');

insert into users_roles (user_id, role_id) values (1, 1);