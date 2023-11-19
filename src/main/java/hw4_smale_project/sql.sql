create table children_sections
(
    child_id integer not null
        references children
        constraint child_section_FK
            references children,
    section_id integer not null
        references sections
        constraint section_child_FK
            references sections,
    primary key (child_id, section_id)
);
--
-- alter table users_roles
--     owner to postgres;


INSERT INTO users (id,name, surname, email, phone, age)
VALUES (1,'Имя1', 'Фамилия1', 'email1@example.com', 1234567890, 5),
       (2,'Имя2', 'Фамилия2', 'email2@example.com', 1234567891, 6),
       (3,'Имя3', 'Фамилия3', 'email3@example.com', 1234567892, 7),
       (4,'Имя4', 'Фамилия4', 'email4@example.com', 1234567893, 8),
       (5,'Имя5', 'Фамилия5', 'email5@example.com', 1234567894, 9),
       (6,'Имя6', 'Фамилия6', 'email6@example.com', 1234567895, 10),
       (7,'Имя7', 'Фамилия7', 'email7@example.com', 1234567896, 8),
       (8,'Имя8', 'Фамилия8', 'email8@example.com', 1234567897, 10),
       (9,'Имя9', 'Фамилия9', 'email9@example.com', 1234567898, 33),
       (10,'Имя10', 'Фамилия10', 'email10@example.com', 1234567899, 34),
       (11,'Имя11', 'Фамилия11', 'email11@example.com', 1234567810, 35),
       (12,'Имя12', 'Фамилия12', 'email12@example.com', 1234567811, 36),
       (13,'Имя13', 'Фамилия13', 'email13@example.com', 1234567812, 37),
       (14,'Имя14', 'Фамилия14', 'email14@example.com', 1234567813, 38),
       (15,'Имя15', 'Фамилия15', 'email15@example.com', 1234567814, 39);

INSERT INTO children (id, category_in_sports, user_id)
VALUES (1, 'Junior', 1),
       (2, 'Senior', 2),
       (3, 'Junior', 3),
       (4, 'Senior', 4),
       (5, 'Junior', 5),
       (6, 'Senior', 6),
       (7, 'Junior', 7),
       (8, 'Senior', 8);

INSERT INTO teachers (id, category, section_id, user_id)
VALUES (1, 'Junior', 1, 9),
       (2, 'Senior', 2, 10),
       (3, 'Junior', 3, 11),
       (4, 'Senior', 3, 12);

insert into sections(id, name)
values (1, 'FB'),
       (2, 'BB'),
       (3, 'GB'),
       (4, 'CH');

insert into children_sections(child_id, section_id)
values (1, 2),
       (2, 2),
       (3, 1),
       (4, 2),
       (5, 1),
       (6, 2),
       (7, 3),
       (8, 3);
-- insert into roles (id, name)
-- VALUES (1, 'тренер'),
--        (2, 'ребенок');

-- insert into users_roles(user_id, role_id)
-- VALUES (1,2),
--        (2,2),
--        (3,2),
--        (4,2),
--        (5,2),
--        (6,2),
--        (7,2),
--        (8,2),
--        (9,1),
--        (10,1),
--        (11,1),
--        (12,1);


