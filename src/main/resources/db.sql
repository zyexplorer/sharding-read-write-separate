CREATE DATABASE master;
USE master;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    id   bigint(64)  not null  AUTO_INCREMENT,
    city varchar(20) not null,
    name varchar(20) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE DATABASE master_slave1;
USE master_slave1;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    id   bigint(64)  not null,
    city varchar(20) not null,
    name varchar(20) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO `master_slave1`.`user`(`id`, `city`, `name`)
VALUES (101, '北京', '赵老二');


CREATE DATABASE master_slave2;
USE master_slave2;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    id   bigint(64)  not null,
    city varchar(20) not null,
    name varchar(20) not null,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
INSERT INTO `master_slave2`.`user`(`id`, `city`, `name`)
VALUES (102, '深圳', '张老三');