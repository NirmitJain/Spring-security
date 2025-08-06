use eazybank;
create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO `users` VALUES ('user','{noop}EazyBytes@12345','1');;
INSERT INTO `authorities` VALUES ('user','read');

INSERT INTO `users` VALUES ('admin','{brcypt}$2a$12$aySKw2wcW3DiydtOSMfdz.6TgxT5gcE4MdK6.CFt/Z7QcfZ7/ISv2','1');;
INSERT INTO `authorities` VALUES ('admin','admin');

CREATE TABLE `customer` (
'id' int NOT NULL AUTO_INCREMENT,
'email' varchar(45) NOT NULL,
'pwd' varchar(200) NOT NULL,
'role' varchar(45) NOT NULL,
PRIMARY KEY (`id`)
);

INSERT INTO `customer` (email,pwd,role) VALUES ('happy@example.com','{noop}EazyBytes@12345','read');
INSERT INTO `customer` (email,pwd,role) VALUES ('admin@example.com','{brcypt}$2a$12$aySKw2wcW3DiydtOSMfdz.6TgxT5gcE4MdK6.CFt/Z7QcfZ7/ISv2','admin');

