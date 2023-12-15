create sequence client_seq;

create table client (
                        id bigint  primary key default nextval('client_seq'),
                        name varchar(255),
                        username varchar(255) unique,
                        password varchar(255),
                        phonenumber varchar(255)
);

create table clientProfile(
                        username varchar(255),
                        name varchar(255),
                        age varchar(255),
                        birthdate varchar(20),
                        userinfo varchar(255),
                        foreign key (username) references client(username)
);

create table clientFriends(
                        username varchar(255),
                        friendusername varchar(255),
                        foreign key (username) references client(username) on update cascade ,
                        foreign key (friendusername) references client(username) on update cascade

);


select * from client;

insert into clientProfile (username, name, age, birthdate, userinfo) values ('gellitta', 'Камиль', '19', '13.03.2004', 'хочу');

update clientProfile set name = 'a', age = 'a', birthdate = 'b', userinfo = 'a' where username = 'krasek';

select * from clientprofile;

select * from clientFriends;

insert into clientFriends(username, friendusername, name) values ('krasek', 'gellitta', 'Камиль')

