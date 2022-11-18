CREATE DATABASE usersDb;

USE usersDb;

CREATE TABLE users (
                       login_user varchar(15) NOT NULL UNIQUE,
                       name_user varchar(40),
                       password_user varchar(30) NOT NULL,
                       PRIMARY KEY (login_user)
);

CREATE TABLE roles (
                       id_role int NOT NULL auto_increment,
                       name_role VARCHAR(30) NOT NULL,
                       PRIMARY KEY(id_role)
);

CREATE TABLE users_roles (
                             id_user_role int NOT NULL auto_increment,
                             login_user VARCHAR(30) NOT NULL,
                             id_role int NOT NULL,
                             PRIMARY KEY(id_user_role),
                             foreign key(login_user) references users(login_user),
                             foreign key(id_role) references roles(id_role)
);