-- all queries should be written in one line

-- creating default users and roles
insert into roles (id, created_at, name) values (1, now(), 'ROLE_ADMIN');
insert into roles (id, created_at, name) values (2, now(), 'ROLE_USER');
insert into users (id, created_at, username, first_name, last_name, password, is_active) values (1, now(), 'admin', 'admin_fn', 'admin_ln', '$2a$12$KZxha94lXyzjGFOAbc.3denh2DwPQYAoB/FHlfLMg4QMYmGuFh7f2', true);
insert into users (id, created_at, username, first_name, last_name, password, is_active) values (2, now(), 'user', 'user_fn', 'user_ln', '$2a$12$KZxha94lXyzjGFOAbc.3denh2DwPQYAoB/FHlfLMg4QMYmGuFh7f2', true);
insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);

-- insert into links (id, created_at, full_url, short_name, short_url, user_id) values (1, now(), 'https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter', 'a', 'http://localhost:8081/api/link/a', 1);

-- insert into sites (id, created_at, created_count, domain) values (1, now(), 1, 'spring.io');