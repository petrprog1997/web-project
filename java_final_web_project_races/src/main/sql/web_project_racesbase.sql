
create database if not exist web_project_racesbase;
use web_project_racesbase;

create table users 
(
	user_id int auto_increment unique not null,
	user_login varchar(20) unique not null,
	user_password varchar(20) not null,
	user_status enum('ACTIVE','BLOCKED') not null,
    user_type enum('CLIENT','BOOKMAKER','ADMINISTRATOR') not null,
    user_money_balance decimal(12,2),
	primary key(user_id)
);

create table runs 
( 
	run_id int auto_increment unique not null,
    run_date date, 
    run_status enum('PLANNED','PASSES','FINISHED'),
    run_winner int not null,
    primary key(run_id)
);

create table run_participants 
(
	run_participant_id int auto_increment unique not null,
    run_id int,
    run_participant_horse_name varchar(20) not null,
    race_participant_number int unique not null,
    run_participant_place int unique not null,
    primary key(run_participant_id),
    constraint run_participant_run_fk foreign key(run_id) references runs(run_id) on delete cascade 
);

create table race_participants 
(
	race_participant_id int auto_increment unique not null,
    run_participant_id int unique,
    race_participant_horse_name varchar(20) not null,
    race_participant_number int unique not null,
    primary key(race_participant_id),
	constraint race_participant_run_participant_fk foreign key(run_participant_id) references 
    run_participants(run_participant_id)
);

create table bets 
(
	bet_id int auto_increment unique not null,
    user_id int,
    run_id int,
    bet_Type enum('WIN','PLACE','SHOW','EACH_WAY','DOUBLE') not null,
	bet_size decimal(12,1) not null,
    coefficient decimal(12,1) not null,
    bet_status enum('PASSED','ACTIIVE','NOT PASSED') not null,
    primary key(bet_id),
    constraint bet_run_fk foreign key(run_id) references runs(run_id) on delete cascade,
    constraint bet_user_fk foreign key(user_id) references users(user_id) on delete cascade
);

insert into users(user_login, user_password, user_status, user_type, user_money_balance)
values (
'admin','admin','ACTIVE','ADMINISTRATOR',null);

insert into race_participants(race_participant_horse_name,race_participant_number) values 
('Ciceron',1),
('Daki',2),
('Almanah',3),
('Saarstaun',4),
('FastCerl',5),
('Boi tzi nail',6),
('Lord Royal',7),
('Mr.Chaki',8),
('Pobeditel',9),
('Konar Lord',10),
('Bashlam',11),
('Kandivo',12),
('Si Coud',13),
('God Dream',14),
('Taimas',15),
('Bremen',16),
('Slava Kassiopeya',17),
('Els Cat',18),
('Centurion',19),
('Conard Lord',20),
('Shtorm Attak',21),
('Tiger Kid',22),
('Suagdon',23);