insert into worker (NAME, BIRTHDAY, level, SALARY) values('Alex1', '1999-09-09', 'Trainee', 100);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Alex2', '2000-09-09', 'Middle', 200);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Alex3', '2001-09-09', 'Junior', 112);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Alex4', '2002-09-09', 'Senior', 1000);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Aomine1', '2003-09-09', 'Junior', 112);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Aomine2', '2004-09-09', 'Trainee', 124);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Aomine3', '2005-09-09', 'Middle', 199);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Aomine4', '2006-09-09', 'Senior', 999);
insert into worker (NAME, BIRTHDAY, level, SALARY) values('Jack1', '2007-09-09', 'Trainee', 151);
insert into worker (NAME, BIRTHDAY, level, SALARY) values ('Jack2', '2008-09-09', 'Junior', 177);

insert into client (NAME) values ('Tema');
insert into client (NAME) values ('Oleksandra');
insert into client (NAME) values ('Pupsik');
insert into client (NAME) values ('Tom');
insert into client (NAME) values ('Bob');

insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Provider service', 1, '2007-07-07', '2008-07-07');
insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('delivery service', 1, '2007-09-09', '2008-09-09');
insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Security service', 1, '2007-10-10', '2008-10-10');

insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Cafe service', 2, '2009-11-11', '2010-11-11');

insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Fitnes service', 3, '2010-12-12', '2011-05-02');
insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Bank service', 3, '2011-02-04', '2012-04-01');

insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Shop service', 4, '2012-03-03', '2012-04-04');
insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Game service', 4, '2013-03-04', '2013-05-05');

insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('Cource service', 5, '2014-04-05', '2015-02-01');
insert into project (NAME, CLIENT_ID, start_date, finish_date) values ('System service', 5, '2022-05-06', '2023-09-06');

insert into project_worker (project_id, worker_id) values (1, 1);

insert into project_worker (project_id, worker_id) values (2, 1);
insert into project_worker (project_id, worker_id) values (2, 2);

insert into project_worker (project_id, worker_id) values (3, 3);
insert into project_worker (project_id, worker_id) values (3, 4);
insert into project_worker (project_id, worker_id) values (3, 5);

insert into project_worker (project_id, worker_id) values (4, 5);
insert into project_worker (project_id, worker_id) values (4, 6);
insert into project_worker (project_id, worker_id) values (4, 7);
insert into project_worker (project_id, worker_id) values (4, 8);

insert into project_worker (project_id, worker_id) values (5, 9);
insert into project_worker (project_id, worker_id) values (5, 10);

insert into project_worker (project_id, worker_id) values (6, 5);


insert into project_worker (project_id, worker_id) values (7, 6);
insert into project_worker (project_id, worker_id) values (7, 7);
insert into project_worker (project_id, worker_id) values (7, 8);

insert into project_worker (project_id, worker_id) values (8, 2);
insert into project_worker (project_id, worker_id) values (8, 4);

insert into project_worker (project_id, worker_id) values (9, 5);
insert into project_worker (project_id, worker_id) values (9, 6);
insert into project_worker (project_id, worker_id) values (9, 7);

insert into project_worker (project_id, worker_id) values (10, 1);
insert into project_worker (project_id, worker_id) values (10, 2);
insert into project_worker (project_id, worker_id) values (10, 3);
insert into project_worker (project_id, worker_id) values (10, 4);
insert into project_worker (project_id, worker_id) values (10, 5);