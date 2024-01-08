create database cg_lms;
use cg_lms;

create table if not exists category
(
    id   int primary key auto_increment,
    name varchar(45) not null
);

insert into category(name)
values ('Lập trình'),
       ('Thuật toán'),
       ('Tiếng anh');
insert into category(name)
values ('Thiết kế');
create table if not exists course
(
    id   int primary key auto_increment,
    name varchar(45) not null,
    description varchar(255) not null ,
    duration int not null,
    instructor varchar(45),
    location varchar(45),
    category_id int not null ,
    foreign key (category_id) references category(id)
);

insert into course (name, description, duration, instructor, location,category_id) values
('Lập trình frontend','Đang cập nhật...',100,'Mr Tèo','CodeGym Sài Gòn',1),
('Lập trình backend','Đang cập nhật...',100,'Mr Tèo','CodeGym Sài Gòn',1),
('Thuật toán tìm kiếm','Đang cập nhật...',200,'Mr Tèo','CodeGym Sài Gòn',2),
('Thuật toán sắp xếp','Đang cập nhật...',200,'Mr Tèo','CodeGym Sài Gòn',2),
('Tiếng anh giao tiếp','Đang cập nhật...',100,'Mr Tèo','CodeGym Sài Gòn',3),
('Tiếng anh chuyên nganh','Đang cập nhật...',100,'Mr Tèo','CodeGym Sài Gòn',3),
('Thiết kế ux/ui','Đang cập nhật...',100,'Mr Tèo','CodeGym Sài Gòn',4),
('thiết kế webite','Đang cập nhật...',100,'Mr Tèo','CodeGym Sài Gòn',4);