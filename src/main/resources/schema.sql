create table if not exists USERS
(
    ID       BIGINT AUTO_INCREMENT PRIMARY KEY,
    USERNAME varchar(255) not null,
    PASSWORD varchar(255) not null,
    EMAIL    varchar(255) not null,
    PRIMARY KEY (ID)
);