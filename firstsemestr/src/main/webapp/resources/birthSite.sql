create sequence client_seq;

create table client (
                        id bigint  primary key default nextval('client_seq'),
                        name varchar(255),
                        username varchar(255) unique,
                        password varchar(255),
                        phonenumber varchar(255)
);

create table clientProfile(
                        id bigint unique,
                        name varchar(255),
                        age varchar(255),
                        birthdate varchar(20),
                        foreign key (id) references client(id)
);

create table clientFriend(
                        clientId bigint ,
                        friendId bigint,
                        name varchar(255),
                        foreign key (clientId) references client(id),
                        foreign key (friendId) references client(id)

);


select * from client;
select * from clientProfile