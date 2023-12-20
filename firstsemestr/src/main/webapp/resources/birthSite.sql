create sequence client_seq;

create table client (
                        id bigint  primary key default nextval('client_seq'),
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

