insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('user', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into sec_role (roleName)
values ('ROLE_USER');
 
insert into sec_role (roleName)
values ('ROLE_ADMIN');
 

insert into user_role (userId, roleId)
values (1, 2);

insert into user_role (userId, roleId)
values (2, 1);