create database nien_luan1;

use nien_luan1;

create table calculate_history(
	id int primary key auto_increment,
	valueA varchar(255) not null,
	operator char(10) not null,
	valueB varchar(255) not null,
	result varchar(255) not null,
    created_date datetime DEFAULT CURRENT_TIMESTAMP
);

insert into calculate_history(valueA, operator, valueB, result) values('1', 'Plus' ,'1', '2');

select * from calculate_history;