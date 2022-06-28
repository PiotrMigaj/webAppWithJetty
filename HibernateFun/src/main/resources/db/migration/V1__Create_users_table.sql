create table users(
    id int primary key auto_increment,
    name varchar(100) not null,
    lastname varchar(100) not null,
    is_adult bit
);