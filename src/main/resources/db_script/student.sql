create table student (
	student_id serial primary key,
	student_name varchar(100),
	father_name varchar(100),
	address varchar(250),
	phone varchar(10),
	status boolean default true,
	is_published default false
);